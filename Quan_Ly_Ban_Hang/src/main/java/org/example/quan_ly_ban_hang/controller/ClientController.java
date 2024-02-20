package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.model.Client;
import org.example.quan_ly_ban_hang.service.client.ClientService;
import org.example.quan_ly_ban_hang.service.client.IClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", urlPatterns = "/client")
public class ClientController extends HttpServlet {
    private static final IClientService clientService = new ClientService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                listClient(req,resp);
                break;
        }
    }
    private void listClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list.jsp");
        List<Client> clients = clientService.getAllClient();
        req.setAttribute("client", clients);
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
                createClient(req,resp);
                break;
        }
    }

    private void createClient(HttpServletRequest req, HttpServletResponse resp) {

    }
}
