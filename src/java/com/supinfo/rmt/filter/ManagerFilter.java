/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.filter;

import com.supinfo.rmt.controller.UserController;
import com.supinfo.rmt.model.Employee;
import com.supinfo.rmt.model.Manager;
import com.supinfo.rmt.model.User;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns={"/faces/manager_home.xhtml", "/faces/add_employee.xhtml", "/faces/add_client.xhtml"})
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        UserController userController = 
            (UserController) httpRequest.getSession().getAttribute("userController");
        
        if(null != userController) {
            User user = userController.getLoggedUser();
            if(user instanceof Manager) {
                chain.doFilter(request, response);
                return;
            }
        }
        
        httpResponse.sendRedirect("login.xhtml");
    }

    @Override
    public void destroy() {
        
    }
}