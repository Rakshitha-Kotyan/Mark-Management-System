<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<main class="main-section">
    <h2>Delete Student Record</h2>

    <form action="DeleteMarkServlet" method="post" class="form-box">
        <label for="studentId">Student ID:</label>
        <input type="number" id="studentId" name="studentId" required>

        <button type="submit" class="btn delete-btn">Delete</button>
    </form>

    <% if (request.getAttribute("status") != null) { %>
        <p class="status-message"><%= request.getAttribute("status") %></p>
    <% } %>

    <a href="index.jsp" class="back-link">← Back to Home</a>
</main>

<%@ include file="footer.jsp" %>
