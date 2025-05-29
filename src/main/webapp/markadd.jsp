<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Marks</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header class="main-header">
    <h1 style="font-size: 20px;">Mark Management System</h1>
</header>


    <main class="main-section">
        <h2>Add Student Mark</h2>

        <% 
            String status = (String) request.getAttribute("status"); 
            if (status != null) { 
        %>
            <div style="text-align: center; font-weight: bold; margin-bottom: 15px; color: <%= status.contains("Success") ? "green" : "red" %>;">
                <%= status %>
            </div>
        <% } %>

        <form class="form-box" action="AddMarkServlet" method="post">
            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId" required>

            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName" name="studentName" required>

            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>

            <label for="marks">Marks:</label>
            <input type="number" id="marks" name="marks" required min="0" max="100">

            <label for="examDate">Exam Date:</label>
            <input type="date" id="examDate" name="examDate" required>

            <button type="submit">Add Mark</button>
        </form>

        <a href="index.jsp" class="back-link">← Back to Home</a>
    </main>

    <footer class="main-footer" style="background-color: #005aa7; color: white;">
    <p>&copy; 2025 MarkWebApp | Developed by Rakshitha Kotyan</p>
</footer>

</body>
</html>
