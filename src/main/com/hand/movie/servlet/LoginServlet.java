package com.hand.movie.servlet;

import com.hand.movie.entity.User;
import com.hand.movie.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName =req.getParameter("firstName");
        User user = null;
        if (firstName != null)
            user=userService.login(firstName);
        if(user!=null)
        {
            req.getSession().setAttribute("loginUser",user);
            resp.sendRedirect("/filmList.jsp");
            return;
        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}
