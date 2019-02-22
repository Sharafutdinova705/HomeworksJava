/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 *
 * @author guzel
 */
public class NewClass {
    
    static String link = "http://www.uniqlo.com/ru/product/women/tops/down";
    static String pathToHtml = "/users/guzel/Desktop/site.html";
    static String pathToXml = "/users/guzel/Desktop/site.xml";
    static String linkToSite = "http://www.uniqlo.com";
    static List<Product> allProducts = new ArrayList<>();
    
    public static void main(String[] args) throws IOException, URISyntaxException, XPatherException {
        
        NewClass nc = new NewClass();
        nc.download(link, pathToHtml);
        nc.parsing();
        
        int count = 0;
        for (Product product : allProducts) {
            count++;
            System.out.println("Product number " + count + ".\nProduct's name: " + product.getName() + "\nProduct's price: " + product.getPrice() + "\nProduct's link: " + product.getLinkToProduct() + "\nImage's link of product: " + product.getLinkToImage() + "\n");
        }
    }
    
    public void download(String link, String path) throws URISyntaxException, IOException {
        
        URI siteUri = new URI(link);
        
        try(BufferedReader in = new BufferedReader(new InputStreamReader(siteUri.toURL().openConnection().getInputStream()))) {
            
            File outputFile = new File(path);
            
            if(!outputFile.exists()){
                
                outputFile.createNewFile();
            }
            
            try(BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))){
                
                String line;
                
                while((line = in.readLine()) != null) {
                    
                    out.write(line + "\n");
                }
                
                out.flush();
            }
        }
    }
    
    public void parsing() throws IOException, XPatherException{
        
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode html = cleaner.clean(new File(pathToXml));
        
        
        Object[] products = html.evaluateXPath("//div[@class='unit']");
        Product product1 = new Product();

        for (Object product : products) {
            TagNode tagNodeProduct = (TagNode) product;
            product1.setName(tagNodeProduct.findElementByAttValue("class", "name", true, true).findElementByName("a", true).getText().toString());
            product1.setPrice(tagNodeProduct.findElementByAttValue("class", "price", true, true).findElementByName("span", true).getText().toString());
            product1.setLinkToProduct(linkToSite + tagNodeProduct.findElementByAttValue("class", "name", true, true).findElementByName("a", true).getAttributeByName("href"));
            product1.setLinkToImage(tagNodeProduct.findElementByAttValue("class", "thumb", true, true).findElementByName("img", true).getAttributeByName("src"));
            allProducts.add(product1);
        }
    }
}

/*
//по 7 баллов за кр и семестровки
//свой собственный магазин состоит из 
1 категорий  
2 товары должны быть поделены на странички 
пагинатор
3 оттуда скачать вообще все товары
//выбираем магазин попроще(не быоо защиты как в амазоне)
//
//
название товара
цену
ссылку на страничку товара
ссылку на картинку
ссылки должны быть полными с указаниями хоста. полная путь
либо в консоль либо в базу записывать
дедлайн - среда
*/