package com.servlet.admin;

import com.pojo.User;
import com.service.user.UserService;
import com.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(userid);
        request.setAttribute("userMsg", user);
        request.getRequestDispatcher("/jsp/admin/admin_adduser.jsp").forward(request, response);
    }
}
