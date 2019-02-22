/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author guzel
 */
public class XmlSimpleConfigTest {

  public static void main(String[] args) {
    new XmlSimpleConfigTest();
  }
  
  public XmlSimpleConfigTest(){
    System.out.println("XML config context configuration test");
    
    ApplicationContext context = 
             new FileSystemXmlApplicationContext(getClass().getResource("/simpleConfig.xml").toString());
    
    System.out.println("XML config context configuration test");
    
    CurrencyTransfer obj = (CurrencyTransfer) context.getBean("currencyTransfer");
    System.out.println( obj.getCurrencyTransfer(100.0) );
  }
}