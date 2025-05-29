package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

public class AddMarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            String studentName = request.getParameter("studentName");
            String subject = request.getParameter("subject");
            int marks = Integer.parseInt(request.getParameter("marks"));
            String examDate = request.getParameter("examDate");

            StudentMark mark = new StudentMark(studentId, studentName, subject, marks, examDate);
            boolean status = MarkDAO.insertMark(mark);

            request.setAttribute("status", status ? "Added Successfully" : "Addition Failed");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "Error occurred: " + e.getMessage());
        }

        request.getRequestDispatcher("markadd.jsp").forward(request, response);
    }
}
