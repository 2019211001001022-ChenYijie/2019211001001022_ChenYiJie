package com.dabing.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//redirect -same server -Relative URL
     //1.start without /
        System.out.println("after redirect");

        response.sendRedirect("index.jsp");//url- change to index.jsp
        //http://localhost:8080/2019211001001022_ChenYiJie_war_exploded/redirect
        //http://localhost:8080/2019211001001022_ChenYiJie_war_exploded/index.jsp
        //see the url -only last past of url change(redirect -->index.jsp)
        System.out.println("after redirect");
     //2.start with /
response.sendRedirect("/2019211001001022_ChenYiJie_war_exploded/index.jsp");//-???-HTTP Status 404 -Not Found
        //why ? -look at url
       //http://localhost:8080/2019211001001022_ChenYiJie_war_exploded/redirect
        //http://localhost:8080/index.jsp
        //url change after 0000 -means tomcat
        //add //2019211001001022_ChenYiJie_war_exploded/

        //redirect - another server -Absolute URL full url
        response.sendRedirect("http://www.baidu.com");
        //https://www.baidu.com
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
