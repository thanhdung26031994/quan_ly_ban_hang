package org.example.quan_ly_ban_hang.controller;

import org.example.quan_ly_ban_hang.dto.DetailDTO;
import org.example.quan_ly_ban_hang.model.Detail;
import org.example.quan_ly_ban_hang.service.detail.DetailService;
import org.example.quan_ly_ban_hang.service.detail.IDetailService;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                listDetail(req,resp);
                break;
        }
    }

    private void listDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("detail/list.jsp");
        List<DetailDTO> detailList = detailService.getAllDetail();
        req.setAttribute("detail", detailList);
        dispatcher.forward(req,resp);

    }
}
