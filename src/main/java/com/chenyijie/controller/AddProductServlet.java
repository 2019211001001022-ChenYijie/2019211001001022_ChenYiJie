package com.chenyijie.controller;

import com.chenyijie.dao.ProductDao;
import com.chenyijie.model.Category;
import com.chenyijie.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "AddProductServlet", value = "/admin/AddProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    private Connection con = null;
    private static final Logger Log = Logger.getLogger(String.valueOf(AddProductServlet.class));

    public void destroy() {
        super.destroy();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);
        String path = "/WEB-INF/views/admin.addproduct.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    } catch(SQLException throwables){
        throwables.printStackTrace();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")) : 0.0;
        int CategoryId = request.getParameter("categoryId") != null ? Integer.parseInt(request.getParameter("categeryId")) : 0;
        String productDescription = request.getParameter("roductDescription");
        InputStream inputStream = null;
        Part filePart = request.getPart("picture");
        if (filePart != null) {
            System.out.println("file name :" + filePart.getSize() + "file type" + filePart.getContentType());
            inputStream = filePart.getInputSteam();
        }
    Product product = new Product();
           product.setProductName(productName);
           product.setPrice(price);
           product.setProductDescrisption(productDescription);
           product.setCategory(categoryId);
ProductDao productDao=new ProductDao();
try{
    int n=productDao.save(product,con);
    if(1>0)
        response.sendRedirect("productList");
}catch(SQLException throwables){
    throwables.printStackTrace();
}
}
}

