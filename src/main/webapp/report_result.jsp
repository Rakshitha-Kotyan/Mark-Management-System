<%@ page import="java.util.List" %>
<%@ page import="com.model.StudentMark" %>
<!DOCTYPE html>
<html>
<head>
    <title>Report Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f9f9f9;
            color: #333;
        }
        h2 {
            color: #004080;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 900px;
            margin-bottom: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #004080;
            color: #fff;
            font-weight: 600;
        }
        tr:hover {
            background-color: #f1f7ff;
        }
        .links a {
            margin-right: 20px;
            color: #004080;
            text-decoration: none;
            font-weight: 600;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .message {
            font-style: italic;
            color: #777;
        }
    </style>
</head>
<body>
    <h2>Report Results</h2>

    <%
        List<StudentMark> reportList = (List<StudentMark>) request.getAttribute("report_result");
        if (reportList == null) {
    %>
        <p class="message">Something went wrong. No data available.</p>
    <%
        } else if (reportList.isEmpty()) {
    %>
        <p class="message">No records found for selected criteria.</p>
    <%
        } else {
    %>
        <table>
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Name</th>
                    <th>Subject</th>
                    <th>Marks</th>
                    <th>Exam Date</th>
                </tr>
            </thead>
            <tbody>
                <% for (StudentMark m : reportList) { %>
                <tr>
                    <td><%= m.getStudentId() %></td>
                    <td><%= m.getStudentName() %></td>
                    <td><%= m.getSubject() %></td>
                    <td><%= m.getMarks() %></td>
                    <td><%= m.getExamDate() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    <%
        }
    %>

    <div class="links">
        <a href="report_form.jsp">&larr; Back to Report Form</a>
        <a href="index.jsp">Home</a>
    </div>
</body>
</html>
