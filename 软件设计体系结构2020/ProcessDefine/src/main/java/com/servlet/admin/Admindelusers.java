package com.servlet.admin;

import com.pojo.User;
import com.service.user.UserService;
import com.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Admindelusers extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int identity = Integer.parseInt(request.getParameter("identity"));
        User deluser = new User(id,username,password,identity);

        String userid = request.getParameter("userid");
        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(userid);
        userService.delUser(id);
        request.setAttribute("userMsg", user);



        int totalUsers = userService.getAllUsers().size(); //用户总数
        List<User> users = userService.getAllUsers();
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("users",users);

        request.getRequestDispatcher("/jsp/admin/admin.jsp").forward(request, response);
    }
}
