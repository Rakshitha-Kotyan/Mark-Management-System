package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Usually reportType and reportValue come from request parameters, not attributes
        String type = request.getParameter("reportType");
        String value = request.getParameter("reportValue");
        List<StudentMark> result = null;

        try {
            switch (type) {
                case "above":
                    int threshold = Integer.parseInt(value);
                    result = MarkDAO.getMarksAboveThreshold(threshold);
                    break;
                case "subject":
                    result = MarkDAO.getMarksBySubject(value);
                    break;
                case "top":
                    int limit = Integer.parseInt(value);
                    result = MarkDAO.getTopNStudents(limit);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid report type");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid number entered.");
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
            return;
        }

        // Change attribute name here to "report_result"
        request.setAttribute("report_result", result);

        request.getRequestDispatcher("report_result.jsp").forward(request, response);
    }
}
