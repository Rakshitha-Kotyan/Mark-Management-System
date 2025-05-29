package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ReportCriteriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("reportType");
        String value = request.getParameter("reportValue");

        if (type == null || value == null || value.trim().isEmpty()) {
            request.setAttribute("error", "Please select a report type and provide a valid value.");
            request.getRequestDispatcher("report_form.jsp").forward(request, response);
            return;
        }

        request.setAttribute("reportType", type);
        request.setAttribute("reportValue", value);
        request.getRequestDispatcher("ReportServlet").forward(request, response);
    }
}
