package org.example.quan_ly_ban_hang.controller;

import javafx.animation.KeyFrame;
import org.example.quan_ly_ban_hang.model.Client;
import org.example.quan_ly_ban_hang.model.Invoice;
import org.example.quan_ly_ban_hang.service.client.ClientService;
import org.example.quan_ly_ban_hang.service.client.IClientService;
import org.example.quan_ly_ban_hang.service.invoice.IInvoiceService;
import org.example.quan_ly_ban_hang.service.invoice.InvoiceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@WebServlet(name = "InvoiceServlet", urlPatterns = "/invoice")
public class InvoiceController extends HttpServlet {
    private static final IInvoiceService invoiceService = new InvoiceService();
    private static final IClientService clientService = new ClientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(req,resp);
                break;
            case "edit":
                showEdit(req,resp);
                break;
            case "delete":
                deleteInvoice(req,resp);
                break;
            default:
                listInvoice(req,resp);
                break;
        }
    }

    private void deleteInvoice(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        invoiceService.moveById(id);
        resp.sendRedirect("/invoice");
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("invoice/edit.jsp");
        Integer id = Integer.valueOf(req.getParameter("id"));
        List<Client> clients = clientService.getAllClient();
        req.setAttribute("client", clients);
        Invoice invoice = invoiceService.findById(id);
        req.setAttribute("invoice", invoice);
        dispatcher.forward(req,resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("invoice/create.jsp");
        List<Client> clients = clientService.getAllClient();
        req.setAttribute("client", clients);
        dispatcher.forward(req,resp);
    }

    private void listInvoice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("invoice/list.jsp");
        List<Invoice> invoiceList = invoiceService.getAllInvoice();
        req.setAttribute("invoice", invoiceList);
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    createInvoice(req,resp);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    editInvoice(req,resp);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void editInvoice(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
//        String name = req.getParameter("name");
        Integer id = Integer.valueOf(req.getParameter("id"));
        String saleDate = req.getParameter("sale");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date sale = dateFormat.parse(saleDate);
        java.sql.Date sql = new java.sql.Date(sale.getTime());

        Float total = Float.valueOf(req.getParameter("total"));
        Integer idClient = Integer.valueOf(req.getParameter("idClient"));
        Client client = new Client(idClient);
        Invoice invoice = new Invoice(id,sql, total, client);
        invoiceService.updateInvoice(invoice);
        resp.sendRedirect("/invoice");
    }

    private void createInvoice(HttpServletRequest req, HttpServletResponse resp) throws ParseException, IOException {
        String name = req.getParameter("name");

        String saleDate = req.getParameter("sale");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date sale = dateFormat.parse(saleDate);
        java.sql.Date sql = new java.sql.Date(sale.getTime());

        Float total = Float.valueOf(req.getParameter("total"));
        Integer idClient = Integer.valueOf(req.getParameter("idClient"));
        Client client = new Client(idClient, name);
        Invoice invoice = new Invoice(sql, total, client);
        invoiceService.addInvoice(invoice);
        resp.sendRedirect("/invoice");
    }
}
