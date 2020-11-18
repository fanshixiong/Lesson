package com.servlet.offdoc;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.pojo.User;
import com.pojo.leave.Leave;
import com.pojo.offdoc.offdocform;
import com.service.leave.LeaveFormService;
import com.service.leave.LeaveFormServiceImpl;
import com.service.leave.teastuService;
import com.service.leave.teastuServiceImpl;
import com.service.offdoc.offdocServiceImpl;
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

public class offdocServlet extends HttpServlet {
    private offdocServiceImpl offdocService = new offdocServiceImpl();
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
     }

     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
         String userName = user.getUserName();

         //teastuService teastuService = new teastuServiceImpl();
         //int post = teastuService.getteastuByName(userName).getPost();
         String methods = request.getParameter("method");

         if (methods.equals("add")) {
             System.out.println("ADDD=======");
             this.addoffdoc(request, response);
         } else if (methods.equals("query")) {
             System.out.println("QUERY=======");
             this.queryoffdoc(request, response);
         } else if (methods.equals("del")) {
             System.out.println("DEL=========");
             this.deloffdoc(request, response);
         }
        }


    public void addoffdoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String reason = request.getParameter("reason");
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();

        offdocform offdoc = new offdocform(id, new Date(), name, reason, new Date(), 0,0,0,0);
        int st = offdocService.addoffdoc(offdoc);
        if (st == 1) {
            this.queryoffdoc(request, response);
        } else {
            request.setAttribute("error", "error!");
            request.getRequestDispatcher("/jsp/offdoc/offdocadd.jsp").forward(request, response);
        }
    }

    public void queryoffdoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String name = user.getUserName();
        System.out.println("==========UserName: " + name);

        List<offdocform> alloffdoc = offdocService.getAlloffdocforms(name);

        request.setAttribute("forms", alloffdoc);
        System.out.println(alloffdoc.get(0).getSstate()+"sadasdasdasdasdas");
        request.getRequestDispatcher("/jsp/offdoc/offdoc_staff.jsp").forward(request, response);
    }
    private void deloffdoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (!StringUtils.isNullOrEmpty(id)) {
            int flag = offdocService.deloffdoc(id);
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


}