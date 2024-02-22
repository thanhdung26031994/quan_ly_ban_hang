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
            case "create":
                showCreate(req,resp);
                break;
            case "edit":
                showEditClient(req,resp);
                break;
            case "delete":
                deleteClient(req,resp);
                break;
            case "arrange":
                arrangeByName(req,resp);
                break;
            default:
                listClient(req,resp);
                break;

        }
    }

    private void arrangeByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String arrange = req.getParameter("arrange");
        List<Client> clientList = clientService.arrangeByName(arrange);
        req.setAttribute("client", clientList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void deleteClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        clientService.moveById(id);
        resp.sendRedirect("/client");
    }

    private void showEditClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/edit.jsp");
        Integer id = Integer.valueOf(req.getParameter("id"));
        Client clients = clientService.findById(id);
        req.setAttribute("client", clients);
        dispatcher.forward(req,resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/create.jsp");
        dispatcher.forward(req,resp);
    }

    private void listClient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/list.jsp");
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
            case "edit":
                editClient(req,resp);
                break;
            case "search":
                searchByName(req,resp);
                break;
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Client> clients = clientService.searchByName(name);
        req.setAttribute("client", clients);
        RequestDispatcher dispatcher = req.getRequestDispatcher("client/search.jsp");
        dispatcher.forward(req,resp);
    }

    private void editClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Client client = new Client(id, name, phone, email, address);
        clientService.updateClient(client);
        resp.sendRedirect("/client");
    }

    private void createClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Client client = new Client(name, phone, email, address);
        clientService.addClient(client);
        resp.sendRedirect("/client");
    }
}
