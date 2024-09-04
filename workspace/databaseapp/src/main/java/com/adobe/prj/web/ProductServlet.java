package com.adobe.prj.web;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); //MIME image/gif image/png text/js text/css application/msword
        // open stream to the client <<Browser>>
        PrintWriter out = resp.getWriter(); // character stream
        out.print("<html>");
        out.print("<body>");
        out.print("<table border=\"1\">");
            out.print("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        ProductDao productDao = new ProductDaoJdbcImpl();
        List<Product> products = productDao.getProducts();
        for(Product p : products) {
            out.print("<tr>");
                out.print("<td>" + p.getId() + "</td>");
                out.print("<td>" + p.getName() + "</td>");
                out.print("<td>" + p.getPrice() + "</td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.print("<a href=\"index.html\">Back </a>");
        out.print("</body>");
        out.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product p = new Product();
        p.setName(req.getParameter("name"));
        p.setPrice(Double.parseDouble(req.getParameter("price")));
        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
            resp.sendRedirect("index.html");
        } catch (PersistenceException e) {
            //System.out.println(e.getMessage()); // for end user
            e.printStackTrace(); // for developers
        }
    }
}
