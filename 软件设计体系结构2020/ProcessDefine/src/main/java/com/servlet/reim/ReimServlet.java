package com.servlet.reim;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.pojo.User;
import com.pojo.reimbursement.ReimForm;
import com.service.reimbursement.ReimFormService;
import com.service.reimbursement.ReimFormServiceImpl;
import com.service.reimbursement.StaffService;
import com.service.reimbursement.StaffServiceImpl;
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

public class ReimServlet extends HttpServlet {
    private ReimFormService reimFormService = new ReimFormServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=====REIMMMM.DOOO");

        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String userName = user.getUserName();
        StaffService staffService = new StaffServiceImpl();
        int post = staffService.getStaffByName(userName).getPost();

        String methods = request.getParameter("method");
        if(post == 0) {
            if (methods.equals("add")) {
                System.out.println("ADDD=======");
                this.addSta1ReimForm(request, response);
            } else if (methods.equals("query")) {
                System.out.println("QUERY=======");
                this.querySta1ReimForm(request, response);
            } else if (methods.equals("delform")) {
                System.out.println("DEL=========");
                this.delSta1ReimForm(request, response);
            }
        }
        else {
            if (methods.equals("query")) {
                System.out.println("QUERY POST1=======");
                this.querySta2ReimForm(request, response);
            } else if (methods.equals("modify")) {
                System.out.println("Modify POST1=========");
                this.modifySta2ReimForm(request, response);
            }
        }
    }

    private void delSta1ReimForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (!StringUtils.isNullOrEmpty(id)) {
            int flag = reimFormService.delReimForm(id);
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

    public void addSta1ReimForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int money = Integer.parseInt(request.getParameter("money"));
        String reason = request.getParameter("reason");
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();

        ReimForm reimForm = new ReimForm(id, money, new Date(), name, reason, new Date(), 0);
        int st = reimFormService.addReimForm(reimForm);
        if (st == 1) {
            this.querySta1ReimForm(request, response);
        } else {
            request.setAttribute("error", "error!");
            request.getRequestDispatcher("/jsp/reimbursement/reimadd.jsp").forward(request, response);
        }
    }

    public void querySta1ReimForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();
        System.out.println("==========UserName: " + name);

        List<ReimForm> allReimForms = reimFormService.getAllReimForms(name);

        request.setAttribute("forms", allReimForms);
        request.getRequestDispatcher("/jsp/reimbursement/reimbursement.jsp").forward(request, response);
    }


    private void modifySta2ReimForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int state = Integer.parseInt(request.getParameter("formstate"));
        System.out.println(id + " " + state);
        HashMap<String, String> results = new HashMap<String, String>();
        int flag = reimFormService.updateReimFormState(id, state, new Date());
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


    private void querySta2ReimForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();
        System.out.println("==========UserName: " + name);

//        List<ReimForm> allReimForms = reimFormService.getReimFormsBystate(0);
        List<ReimForm> allReimForms = reimFormService.getAllForms();

        List<ReimForm> forms1 = new ArrayList<>();
        List<ReimForm> forms2 = new ArrayList<>();
        for (ReimForm allReimForm : allReimForms) {
            if(allReimForm.getMoney() <= 100){
                forms1.add(allReimForm); //科长
            }
            else{
                forms2.add(allReimForm); //处长
            }
        }

        if(new StaffServiceImpl().getStaffByName(name).getPost() == 2) {
            request.setAttribute("forms", forms2);
        }
        else {
            request.setAttribute("forms", forms1);
        }
        request.getRequestDispatcher("/jsp/reimbursement/reimbursement2.jsp").forward(request, response);
    }

}
