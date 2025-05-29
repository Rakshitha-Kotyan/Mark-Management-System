package com.servlet;

import com.dao.MarkDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteMarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        boolean status = MarkDAO.deleteMark(studentId);

        request.setAttribute("status", status ? "Deleted Successfully" : "Delete Failed");
        request.getRequestDispatcher("markdelete.jsp").forward(request, response);
    }
}
