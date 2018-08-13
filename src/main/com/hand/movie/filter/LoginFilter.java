package com.hand.movie.filter;
import com.hand.movie.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String path = req.getRequestURI();
        if(path.indexOf("/index.jsp") > -1||path.indexOf("/login") >-1||path.indexOf("/resources") >-1) {
            filterChain.doFilter(req, resp);
            return;
        } else {
            User user = (User) session.getAttribute("loginUser");
            if (user == null) {
                resp.sendRedirect("login.jsp");
            } else {
                filterChain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
