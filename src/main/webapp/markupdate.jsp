<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Marks</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header class="main-header">
    <h1 style="font-size: 20px;">Mark Management System</h1>
</header>


    <main class="main-section">
        <h2>Update Student Marks</h2>

        <form action="UpdateMarkServlet" method="post" class="form-box">
            <label for="studentId">Student ID:</label>
            <input type="number" id="studentId" name="studentId" required>

            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>

            <label for="marks">New Marks:</label>
            <input type="number" id="marks" name="marks" required>

            <button type="submit">Update</button>
        </form>

        <p class="success-msg">
            <%= request.getAttribute("status") != null ? request.getAttribute("status") : "" %>
        </p>

        <a class="back-link" href="index.jsp">← Back to Home</a>
    </main>

    <footer class="main-footer" style="background-color: #005aa7; color: white;">
    <p>&copy; 2025 MarkWebApp | Developed by Rakshitha Kotyan</p>
</footer>

</body>
</html>
