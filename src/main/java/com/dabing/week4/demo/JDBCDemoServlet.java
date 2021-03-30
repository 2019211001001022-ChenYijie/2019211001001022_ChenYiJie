package com.dabing.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@ WebServlet(
        urlPatterns={"/jdbc"},
        initParams={
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseName=userdb;"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="admin123456789")},loadOnStartup= 1

        )

public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;//class variable
    @Override
    public void init() throws ServletException {
        //only one connection
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc.sqlserver://localhost:databaseName=userdb";
        String username = "sa";
        String password = "admin123456789";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->"+con);//ok
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //connection within do get --many time -bad may
        System.out.println("i am in doGet()");//ok
        //we need to use con within doget
        String sql = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                //get from rs- print - write into response
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
