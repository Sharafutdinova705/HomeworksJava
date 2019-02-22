/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author guzel
 */
public class Product {
    
    private String name;
    private String price;
    private String linkToProduct;
    private String linkToImage;
    
    public Product() {
        
    }
    
    public Product(String name, String price, String linkToProduct, String linkToImage) {
        
        this.name = name;
        this.price = price;
        this.linkToProduct = linkToProduct;
        this.linkToImage = linkToImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLinkToProduct() {
        return linkToProduct;
    }

    public void setLinkToProduct(String linkToProduct) {
        this.linkToProduct = linkToProduct;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public void setLinkToImage(String linkToImage) {
        this.linkToImage = linkToImage;
    }
}
