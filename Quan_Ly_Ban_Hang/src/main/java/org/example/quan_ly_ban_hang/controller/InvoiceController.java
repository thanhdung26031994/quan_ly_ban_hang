package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Invoice;
import org.example.quan_ly_ban_hang.service.invoice.IInvoiceService;
import org.example.quan_ly_ban_hang.service.invoice.InvoiceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InvoiceServlet", urlPatterns = "/invoice")
public class InvoiceController extends HttpServlet {
    private static final IInvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                listInvoice(req,resp);
                break;
        }
    }

    private void listInvoice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("invoice/list.jsp");
        List<Invoice> invoiceList = invoiceService.getAllInvoice();
        req.setAttribute("invoice", invoiceList);
        dispatcher.forward(req,resp);
    }
}
