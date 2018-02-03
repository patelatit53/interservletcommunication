package com.rajeshpatkar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "D1", urlPatterns = {"/D1"})
public class D1 extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, 
                        HttpServletResponse response)
                        throws ServletException, 
                        IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet D1</title>"); 
            out.println("</head>");
            out.println("<body>");
            String str = request.getParameter("msg");
            ServletContext sc = getServletContext();
            sc.setAttribute("msg",str);
            out.println("<h1>Servlet D1 Recieved -->"+ str+"</h1>");
            String msgvalue = (String)sc.getAttribute("msg");
            out.println(
                    "<h1>msg attribute in ServletContext has value -->"
                    + msgvalue
                    +"</h1>"
            );
            out.println("</body>");
            out.println("</html>");
        }
    }
}