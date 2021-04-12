package com.dabing.week3.demo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    public Connection dbConn;
    public void init() {

        try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            dbConn = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"), getServletConfig().getServletContext().getInitParameter("Username"), getServletConfig().getServletContext().getInitParameter("Password"));
        } catch (Exception e) {
            System.out.println(e); } }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name,password,email,gender,date;
        name = request.getParameter("name");
        password = request.getParameter("password");email = request.getParameter("email");
        gender = request.getParameter("gender");date = request.getParameter("date");
        PrintWriter writer = response.getWriter();
        String[][] r = new String[1000][6];
        int  a= 0;



        try {
            Statement createDbStatement = dbConn.createStatement();
            String ADDdbRequire = "insert into usertable values('" + name + "','" + password + "','" + email + "','" + gender + "','" + date + "')";
            createDbStatement.executeUpdate(ADDdbRequire);
            String dbRequire = "select * from usertable";
            ResultSet resultDb = createDbStatement.executeQuery(dbRequire);
            while (resultDb.next()) {
                r[a][0] = resultDb.getObject(1).toString().trim();r[a][1] = resultDb.getObject(2).toString().trim();
                r[a][2] = resultDb.getObject(3).toString().trim();r[a][3] = resultDb.getObject(4).toString().trim();
                r[a][4] = resultDb.getObject(5).toString().trim();r[a++][5] = resultDb.getObject(6).toString().trim();
            }
            Object rs = null;
            request.setAttribute("rsname",rs);

            request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("i am in RegisterServlet-->doPost()--> after forward()");
        } catch (Exception e) {
            System.out.println(e);
        }
        writer.println("<table border=\"2\"width=\"80%\"borderColor=\"pink\"bgcolor=\"#DCE3F5\"><tr><td>ID</td><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
        for (int x = 0; x < a; x++) {for (int y = 0; y < 6; y++) { writer.println("<td>" + r[x][y] + "</td>");}
            writer.println("</tr>"); }writer.println("</table>");
    }}


