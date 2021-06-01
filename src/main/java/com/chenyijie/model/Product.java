package com.chenyijie.model;

import java.io.InputStream;

public class Product {

    public Product quantity;
    private int productId;
    private String productName;
    private String productDescription;
    private InputStream picture;
    private Double price;
    private int categoryId;
    private String productDescrisption;

    public Product(){

    }
    public Product(Integer categoryId,String productName,
                   String productDescription,InputStream picture,Double price){
        this.productId = productId;
        this.productName = productName;
        this.productDescription =productDescription;
        this.picture = picture;
        this.price =price;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }

    public void setProductDescrisption(String productDescrisption) {
        this.productDescrisption = productDescrisption;
    }
}

