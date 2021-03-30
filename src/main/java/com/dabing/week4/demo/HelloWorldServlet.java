package com.dabing.week4.demo;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;



public class HelloWorldServlet extends HttpServlet {
    String name="ChenYiJie";
    String id="2019211001001022";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer=response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        Date date=new Date();
        writer.println("name: "+name+"<br/>");
        writer.println("id: "+id+"<br/>");
        writer.println("Date and Time: "+date.toString()+"<br/>");
    }






    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}

