package servlets;

import beans.Product;
import dao.AbstractDao;
import dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");

        String productName = req.getParameter("productName");
        int quantityProduct = Integer.parseInt(req.getParameter("quantityProduct"));
        double price = Double.parseDouble(req.getParameter("price"));

        Product product = new Product();
        product.setProductName(productName);
        product.setQuantityProduct(quantityProduct);
        product.setPrice(price);
        AbstractDao<Product> productDao = new ProductDao();
        productDao.create(product);
        rd.forward(req,resp);

        System.out.println(productName);
        System.out.println(quantityProduct);
        System.out.println(price);
    }


}

