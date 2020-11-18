package com.servlet.leave;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.pojo.User;
import com.pojo.leave.Leave;
import com.service.leave.LeaveFormService;
import com.service.leave.LeaveFormServiceImpl;
import com.service.leave.TeastuService;
import com.service.leave.TeastuServiceImpl;
import com.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StudentServlet extends HttpServlet {
    private LeaveFormService LeaveFormService = new LeaveFormServiceImpl();
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
     }

     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("=====studentservlet.DOOO");
         User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
         String userName = user.getUserName();

         TeastuService teastuService = new TeastuServiceImpl();
         int post = teastuService.getteastuByName(userName).getPost();
         String methods = request.getParameter("method");
        if(post==0){
         if (methods.equals("add")) {
             System.out.println("ADDD=======");
             this.addLeaveForm(request, response);
         } else if (methods.equals("query")) {
             System.out.println("QUERY=======");
             this.queryLeaveForm(request, response);
         } else if (methods.equals("del")) {
             System.out.println("DEL=========");
             this.delLeaveForm(request, response);
         }
        }
        else{
            if (methods.equals("query")) {
                System.out.println("QUERY POST1=======");
                this.querytealeaveForm(request, response);
            }else if (methods.equals("modify")) {
                System.out.println("Modify POST1=========");
                this.modifyLeaveForm(request, response);

            }
        }
     }
    public void addLeaveForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String reason = request.getParameter("reason");
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();

        Leave leave = new Leave(id, new Date(), name, reason, new Date(), 0);
        int st = LeaveFormService.addLeaveForm(leave);
        if (st == 1) {
            this.queryLeaveForm(request, response);
        } else {
            request.setAttribute("error", "error!");
            request.getRequestDispatcher("/jsp/leave/leaveadd.jsp").forward(request, response);
        }
    }

    public void queryLeaveForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();
        System.out.println("==========UserName: " + name);

        List<Leave> allLeaveForms = LeaveFormService.getAllLeaveForms(name);

        request.setAttribute("forms", allLeaveForms);
        request.getRequestDispatcher("/jsp/leave/leave_student.jsp").forward(request, response);
    }
    private void delLeaveForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (!StringUtils.isNullOrEmpty(id)) {
            int flag = LeaveFormService.delLeaveForm(id);
            System.out.println(flag);
            if (flag == 1) {//删除成功
                resultMap.put("delResult", "true");
            } else {//删除失败
                resultMap.put("delResult", "false");
            }
        } else {
            resultMap.put("delResult", "notexit");
        }
        // 转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }

    private void querytealeaveForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();
        System.out.println("==========UserName: " + name);

        List<Leave> allLeaveForms = LeaveFormService.getAllLeave() ;

        List<Leave> forms1 = new ArrayList<>();
        List<Leave> forms2 = new ArrayList<>();
        for (Leave allLeaveForm : allLeaveForms) {
            if(allLeaveForm.getState()==0){
                forms1.add(allLeaveForm); //交给辅导员
            }
            else if(allLeaveForm.getState()>=1)
            {
                forms2.add(allLeaveForm); //交给院长
            }
        }

        if(new TeastuServiceImpl().getteastuByName(name).getPost() == 2) {
            request.setAttribute("forms", forms2);
        }
        else {
            request.setAttribute("forms", forms1);
        }
        request.getRequestDispatcher("/jsp/leave/teacher.jsp").forward(request, response);
    }

    private void modifyLeaveForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        int state = Integer.parseInt(request.getParameter("formstate"));
        System.out.println(id + " " + state);
        HashMap<String, String> results = new HashMap<String, String>();
        int flag = LeaveFormService.updateLeaveFormState(id, state, new Date());
        System.out.println(flag);
        if (flag == 1) {
            results.put("result", "true");
        } else {
            results.put("result", "false");
        }
        // 转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(results));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
}