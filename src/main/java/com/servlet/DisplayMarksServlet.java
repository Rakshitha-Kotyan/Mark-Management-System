package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DisplayMarksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("studentId");
        List<StudentMark> marks;

        if (sid != null && !sid.isEmpty()) {
            marks = MarkDAO.getMarksByStudentId(Integer.parseInt(sid));
        } else {
            marks = MarkDAO.getAllMarks();
        }

        request.setAttribute("marks", marks);
        request.getRequestDispatcher("markdisplay.jsp").forward(request, response);
    }
}
