package com.dao;

import com.model.StudentMark;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class MarkDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password"; // change this

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL 8+
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Insert Mark
 // Insert Mark
    public static boolean insertMark(StudentMark mark) {
        String sql = "INSERT INTO studentmarks (StudentID, StudentName, Subject, Marks, ExamDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, mark.getStudentId());
            ps.setString(2, mark.getStudentName());
            ps.setString(3, mark.getSubject());
            ps.setInt(4, mark.getMarks());
            ps.setDate(5, Date.valueOf(mark.getExamDate()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("SQL Error in insertMark: " + e.getMessage());
            e.printStackTrace(); // Optional: if you still want the full stack trace
        }
        return false;
    }


    // Update Mark
    public static boolean updateMark(int studentId, String subject, int marks) {
        String sql = "UPDATE studentmarks SET Marks = ? WHERE StudentID = ? AND Subject = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, marks);
            ps.setInt(2, studentId);
            ps.setString(3, subject);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Mark
    public static boolean deleteMark(int studentId) {
        String sql = "DELETE FROM studentmarks WHERE StudentID = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get All Marks
    public static List<StudentMark> getAllMarks() {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM studentmarks";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StudentMark mark = new StudentMark(
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getString("Subject"),
                        rs.getInt("Marks"),
                        rs.getDate("ExamDate").toString()
                );
                list.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get Marks by StudentID
    public static List<StudentMark> getMarksByStudentId(int studentId) {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM studentmarks WHERE StudentID = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentMark mark = new StudentMark(
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getString("Subject"),
                        rs.getInt("Marks"),
                        rs.getDate("ExamDate").toString()
                );
                list.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get Marks Above Threshold
    public static List<StudentMark> getMarksAboveThreshold(int threshold) {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM studentmarks WHERE Marks > ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, threshold);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentMark mark = new StudentMark(
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getString("Subject"),
                        rs.getInt("Marks"),
                        rs.getDate("ExamDate").toString()
                );
                list.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get Marks By Subject
    public static List<StudentMark> getMarksBySubject(String subject) {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM studentmarks WHERE Subject = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, subject);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentMark mark = new StudentMark(
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getString("Subject"),
                        rs.getInt("Marks"),
                        rs.getDate("ExamDate").toString()
                );
                list.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Get Top N Students by Marks (descending)
    public static List<StudentMark> getTopNStudents(int n) {
        List<StudentMark> list = new ArrayList<>();
        String sql = "SELECT * FROM studentmarks ORDER BY Marks DESC LIMIT ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, n);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentMark mark = new StudentMark(
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getString("Subject"),
                        rs.getInt("Marks"),
                        rs.getDate("ExamDate").toString()
                );
                list.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
