package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.dto.DetailCreate;
import org.example.quan_ly_ban_hang.dto.DetailDTO;
import org.example.quan_ly_ban_hang.model.Client;
import org.example.quan_ly_ban_hang.model.Detail;
import org.example.quan_ly_ban_hang.model.Invoice;
import org.example.quan_ly_ban_hang.model.Product;
import org.example.quan_ly_ban_hang.service.client.ClientService;
import org.example.quan_ly_ban_hang.service.client.IClientService;
import org.example.quan_ly_ban_hang.service.detail.DetailService;
import org.example.quan_ly_ban_hang.service.detail.IDetailService;
import org.example.quan_ly_ban_hang.service.invoice.IInvoiceService;
import org.example.quan_ly_ban_hang.service.invoice.InvoiceService;
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

@WebServlet(name = "DetailServlet", urlPatterns = "/detail")
public class DetailController extends HttpServlet {
    private static final IDetailService detailService = new DetailService();
    private static final IInvoiceService invoiceService = new InvoiceService();
    private static final IClientService clientService = new ClientService();
    private static final IProductService productService = new ProductService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                showCreate(req,resp);
                break;
            default:
                listDetail(req,resp);
                break;
        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("detail/create.jsp");
        List<Invoice> invoiceList = invoiceService.getAllInvoice();
        req.setAttribute("invoice", invoiceList);
        List<Product> products = productService.getAllProduct();
        req.setAttribute("product", products);
        List<Client> clientList = clientService.getAllClient();
        req.setAttribute("client", clientList);
        dispatcher.forward(req,resp);
    }

    private void listDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("detail/list.jsp");
        List<DetailDTO> detailList = detailService.getAllDetail();
        req.setAttribute("detail", detailList);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                createDetail(req,resp);
                break;
        }
    }

    private void createDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer idInvoice = Integer.valueOf(req.getParameter("idInvoice"));

        Integer idProduct = Integer.valueOf(req.getParameter("idProduct"));
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));
        DetailCreate detailCreate = new DetailCreate(idInvoice, idProduct, quantity);
        detailService.addDetail(detailCreate);

        resp.sendRedirect("/detail");
    }
}
