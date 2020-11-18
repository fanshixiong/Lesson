package com.servlet;

import com.pojo.User;
import com.service.user.UserService;
import com.service.user.UserServiceImpl;
import com.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("LOGIN.DOOO");
        //获取用户名和密码
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        System.out.println(userName + " " + userPassword);
        //调用service方法，进行用户匹配
        UserService userService = new UserServiceImpl();
        User user = userService.login(userName, userPassword);
        //用户身份选择
        if (null != user) {//登录成功
            //放入session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            if(user.getIdentity().equals(0)) {
                request.setAttribute("userMsg", user);
                List<User> users = userService.getAllUsers();
                int totalUsers = users.size(); //用户总数
                request.setAttribute("totalUsers", totalUsers);
                request.setAttribute("users",users);
                request.getRequestDispatcher("/jsp/admin/admin.jsp").forward(request, response);
            }
            if(user.getIdentity().equals(1)){
                request.getSession().setAttribute(Constants.USER_SESSION, user);
                request.getRequestDispatcher("/jsp/frame.jsp").forward(request, response);
            }
        }
        else {
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error","     the username or password is wrong!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
