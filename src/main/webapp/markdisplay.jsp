<%@ page import="java.util.List" %>
<%@ page import="com.model.StudentMark" %>
<%@ page import="com.dao.MarkDAO" %>

<%@ include file="header.jsp" %>

<h2>All Student Marks</h2>

<form action="markdisplay.jsp" method="get" class="form-container">
    <label>Search by Student ID:</label>
    <input type="number" name="studentId" placeholder="Enter ID">
    <input type="submit" value="Search" class="btn">
</form>

<table class="styled-table">
    <tr>
        <th>Student ID</th>
        <th>Name</th>
        <th>Subject</th>
        <th>Marks</th>
        <th>Exam Date</th>
    </tr>

<%
    String sid = request.getParameter("studentId");
    List<StudentMark> list;
    if (sid != null && !sid.isEmpty()) {
        int id = Integer.parseInt(sid);
        list = MarkDAO.getMarksByStudentId(id);
    } else {
        list = MarkDAO.getAllMarks();
    }

    for (StudentMark m : list) {
%>
    <tr>
        <td><%= m.getStudentId() %></td>
        <td><%= m.getStudentName() %></td>
        <td><%= m.getSubject() %></td>
        <td><%= m.getMarks() %></td>
        <td><%= m.getExamDate() %></td>
    </tr>
<% } %>
</table>

<a href="index.jsp" class="back-link">← Back to Home</a>

<%@ include file="footer.jsp" %>
