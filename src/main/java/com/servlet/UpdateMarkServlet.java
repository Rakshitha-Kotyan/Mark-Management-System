package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateMarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String subject = request.getParameter("subject");
        int marks = Integer.parseInt(request.getParameter("marks"));

        boolean status = MarkDAO.updateMark(studentId, subject, marks);

        request.setAttribute("status", status ? "Updated Successfully" : "Update Failed");
        request.getRequestDispatcher("markupdate.jsp").forward(request, response);
    }
}
