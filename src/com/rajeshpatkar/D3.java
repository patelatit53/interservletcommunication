package com.rajeshpatkar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "D3", urlPatterns = {"/D3"})
public class D3 extends HttpServlet {

    @Override
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet D3</title>");
            out.println("</head>");
            out.println("<body>");
            ServletContext sc = getServletContext();
            String str = (String) sc.getAttribute("msg");
            sc.removeAttribute("msg");
            out.println(
                 "<h1>Servlet D3 Removes 'msg' Attribute <br>"
                 + " with value "+ str
                 + "<br>in Servlet Context</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}