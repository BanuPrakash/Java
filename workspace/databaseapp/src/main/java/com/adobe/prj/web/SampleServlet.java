package com.adobe.prj.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("sample")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html"); //MIME image/gif image/png text/js text/css application/msword
       // open stream to the client <<Browser>>
        PrintWriter out = resp.getWriter(); // character stream
        out.print("<html>");
        out.print("<body>");
            out.print("<h1> Date " + new Date() + ", from Server </h1>");
        out.print("</body>");
        out.print("</html>");
    }
}
