<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Reports</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .container {
            max-width: 600px;
            margin: 40px auto;
            background: #ffffffcc;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        .container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #004080;
        }

        .radio-group {
            margin-bottom: 20px;
        }

        .radio-option {
            display: block;
            margin-bottom: 10px;
            font-size: 16px;
        }

        form label {
            font-weight: 600;
            margin-bottom: 6px;
            display: block;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            margin-bottom: 20px;
            font-size: 16px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #005aa7;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #004080;
        }

        .link-group {
            margin-top: 25px;
            text-align: center;
        }

        .nav-link {
            margin: 0 10px;
            text-decoration: none;
            color: #6200ea;
            font-weight: 500;
        }

        .nav-link:hover {
            text-decoration: underline;
        }

        footer {
            margin-top: 50px;
            text-align: center;
            color: #555;
            font-size: 14px;
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <header style="background-color: #005aa7; padding: 20px 0;">
        <h1 style="color: white; text-align: center; margin: 0;">Mark Management System</h1>
    </header>

    <nav class="link-group">
        <a class="nav-link" href="index.jsp">Home</a>
        <a class="nav-link" href="markadd.jsp">Add Marks</a>
        <a class="nav-link" href="markupdate.jsp">Update Marks</a>
        <a class="nav-link" href="markdelete.jsp">Delete Marks</a>
        <a class="nav-link" href="markdisplay.jsp">Display Marks</a>
        <a class="nav-link" href="report_form.jsp">Generate Reports</a>
    </nav>

    <main class="container">
        <h2>Select Report Criteria</h2>

        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>

        <form action="ReportCriteriaServlet" method="post">
            <label>Select Report Type:</label>
            <div class="radio-group">
                <label class="radio-option">
                    <input type="radio" name="reportType" value="above" required>
                    Marks above threshold
                </label>
                <label class="radio-option">
                    <input type="radio" name="reportType" value="subject">
                    Students in specific subject
                </label>
                <label class="radio-option">
                    <input type="radio" name="reportType" value="top">
                    Top N scorers
                </label>
            </div>

            <label>Enter Value:</label>
            <input type="text" name="reportValue" required>

            <input type="submit" value="Generate Report">
        </form>

        <div class="link-group">
            <a class="back-link" href="index.jsp">← Back to Home</a>
        </div>
    </main>

    <footer class="main-footer" style="background-color: #005aa7; color: white;">
    <p>&copy; 2025 MarkWebApp | Developed by Rakshitha Kotyan</p>
</footer>

</body>
</html>
