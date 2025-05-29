
# Student Mark Management System

A comprehensive web application for managing student examination marks built with JSP, Servlets, and MySQL following MVC architecture principles.

## 🚀 Features

- **Complete CRUD Operations**: Add, Update, Delete, and Display student marks  
- **Advanced Search**: Search student records by ID  
- **Dynamic Reports**: Generate insightful reports including:  
  - Students scoring above a certain threshold  
  - Students filtered by subject  
  - Top N students based on marks  
- **Input Validation**: Both client-side (JavaScript) and server-side (Servlets)  
- **Responsive UI**: Built with Bootstrap for a professional look across devices  
- **MVC Architecture**: Separation of concerns between model, view, and controller  
- **MySQL Integration**: JDBC-based backend connectivity  

## 📋 Prerequisites

Make sure the following are installed:

- Java Development Kit (JDK) 8+
- Apache Tomcat 9.0+
- MySQL Server 5.7+ or XAMPP
- MySQL JDBC Driver
- Java IDE (Eclipse, IntelliJ IDEA, etc.)
- Web Browser (Chrome, Firefox, Edge)



## 🛠️ Project Structure

```
MarkWebApp/
├── src/
│   ├── dao/
│   │   └── MarkDAO.java
│   ├── model/
│   │   └── StudentMark.java
│   └── servlet/
│       ├── AddMarkServlet.java
│       ├── UpdateMarkServlet.java
│       ├── DeleteMarkServlet.java
│       ├── DisplayMarksServlet.java
│       ├── ReportServlet.java
│       └── ReportCriteriaServlet.java
├── WebContent/
│   ├── index.jsp
│   ├── markadd.jsp
│   ├── markupdate.jsp
│   ├── markdelete.jsp
│   ├── markdisplay.jsp
│   ├── reports.jsp
│   ├── report_form.jsp
│   ├── report_result.jsp
│   └── css/
│       └── styles.css
├── WEB-INF/
│   └── web.xml
└── README.md
```

## 🗄️ Database Setup

### 1. Create Database

```sql
CREATE DATABASE IF NOT EXISTS mark_management;
USE mark_management;
```

### 2. Create Table

```sql
CREATE TABLE IF NOT EXISTS StudentMarks (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100) NOT NULL,
    Subject VARCHAR(50) NOT NULL,
    Marks INT NOT NULL,
    ExamDate DATE NOT NULL
);
```

### 3. Insert Sample Data

```sql
INSERT INTO StudentMarks VALUES
  (1001, 'Samay Shetty', 'Mathematics', 85, '2025-04-10'),
  (1002, 'Glanil Dsouza', 'Physics', 92, '2025-04-12'),
  (1003, 'Shravya Nair', 'Chemistry', 78, '2025-04-15'),
  (1004, 'Swanjith AS', 'Biology', 89, '2025-04-10'),
  (1005, 'Siddharth SM', 'Computer Science', 95, '2025-04-18');
```

## ⚙️ Installation & Setup

### Step 1: Download the Project
Organize project files according to the structure above.

### Step 2: Configure Database

1. Start MySQL server  
2. Run the SQL setup scripts  
3. Update DB credentials in `MarkDAO.java`:

```java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mark_management",
    "your_username",
    "your_password");
```

### Step 3: Add JDBC Driver

1. Download MySQL Connector/J  
2. Place the JAR file in `WEB-INF/lib`  
3. Add it to build path in IDE  

### Step 4: Deploy to Tomcat

1. Create a Dynamic Web Project in your IDE  
2. Copy files to corresponding folders  
3. Deploy to Tomcat and start server  

### Step 5: Run the App

```
http://localhost:8080/MarkWebApp/
```

## 🖼️ Screenshots

### 🏠 Home Page
![Home](screenshots/Homepage.png)

### ➕ Add Marks Page
![Add](screenshots/add.png)

### 🔍 Search Student
![Search](screenshots/search.png)

### ❌ Delete Record
![Delete](screenshots/delete.png)

### 🆕 Update Record
![Update](screenshots/update.png)

### 📋 Display Marks
![Display](screenshots/display.png)

## 🎯 Application Usage

### Add Student Mark

- Fill all fields: ID, Name, Subject, Marks (0-100), Exam Date  
- Click **Add Student Mark**

### Update Marks

- Search by Student ID  
- Modify fields  
- Click **Update Student Mark**

### Delete Record

- Search by ID  
- Confirm deletion  
- Click **Delete Student Record**

### Display Records

- View all or search by ID  
- Use action buttons to Edit/Delete

### Generate Reports

- Choose type:
  - **Above Threshold**: Enter minimum marks  
  - **By Subject**: Choose subject  
  - **Top N Students**: Specify number  
- Click **Generate Report**

## 🔧 Technical Features

### Validation

- **Client-side**: JavaScript, Bootstrap  
- **Server-side**: Java servlets  
- **DB-level**: Constraints like NOT NULL, PRIMARY KEY  

### Error Handling

- Try-catch for DB ops  
- Friendly messages  
- Invalid input management  

### Security

- Prepared statements  
- Session management  
- Input validation  

### UI Design

- Responsive with Bootstrap 5.3  
- Hover effects and print-friendly reports  

## 🧪 Testing Guide

### Add

- Valid inserts  
- Duplicate IDs (fail)  
- Missing/invalid fields (fail)  

### Update

- Existing records (pass)  
- Non-existent ID (fail)  

### Delete

- Existing (pass)  
- Non-existent (fail)  

### Display

- All records  
- Search valid/invalid ID  

### Reports

- All report types  
- Valid/invalid criteria  

## 🎓 Learning Outcomes

- MVC architecture in practice  
- Full-stack development using Java EE  
- CRUD with JDBC and MySQL  
- Client/server-side validation  
- Dynamic reporting with filtering  
- UI/UX using Bootstrap
