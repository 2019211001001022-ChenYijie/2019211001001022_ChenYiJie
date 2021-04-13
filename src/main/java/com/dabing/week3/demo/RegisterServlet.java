package com.dabing.week3.demo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();

        /*String driver = getServletConfig().getServletContext().getInitParameter("driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String username = getServletConfig().getServletContext().getInitParameter("username");
        String password = getServletConfig().getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("init()" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");



        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthdate)" +
                    "values('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthdate +"')";
            System.out.println("sql " + sql);

            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);

            sql = "select * from usertable";
            ResultSet rs = st.executeQuery(sql);
            PrintWriter printWriter = response.getWriter();

                /*printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<meta charset='UTF-8'>");
            printWriter.println("<title>显示所有</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("username:"+username);
            printWriter.println("<br/>password:"+password);
            printWriter.println("<br/>email:"+email);
            printWriter.println("<br/>gender:"+gender);
            printWriter.println("<br/>birthdate:"+birthdate);
            printWriter.println("<br/></body>");
            printWriter.println("</html>");*/
            /*request.setAttribute("rsname",rs);
            request.getRequestDispatcher("userList.jsp").forward(request,response);*/

            response.sendRedirect("login.jsp");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}


