package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Product;
import org.example.quan_ly_ban_hang.service.product.IProductService;
import org.example.quan_ly_ban_hang.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private static final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                listProduct(req, resp);
                break;
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.getAllProduct();
        req.setAttribute("product", products);
        dispatcher.forward(req,resp);
    }
}
