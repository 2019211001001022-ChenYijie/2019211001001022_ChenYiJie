package com.dabing.week6.demo;
import javax.servlet.FilterConfig;
import  javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContextEvent context= (ServletContextEvent) sce.getServletContext();
        FilterConfig connect = null;
        String driver=connect.getInitParameter("driver");
        String  url=context.getInitParameter("url");
        String  username=connect.getInitParameter("username");
        String password=connect.getInitParameter("password");
            try {
                Class.forName(driver);
              Connection con= DriverManager.getConnection(url,username,password);
                System.out.println("i am in contextInitialized()-->"+con);
                //System.out.println("init()-->"+con);
                context.setAttribute("con",con);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        System.out.println("i am in contextInitialized()");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){

        System.out.println("i am in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");
    }
}
