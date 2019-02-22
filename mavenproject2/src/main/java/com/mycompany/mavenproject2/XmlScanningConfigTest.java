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
public class XmlScanningConfigTest {

  public static void main(String[] args) {
    new XmlScanningConfigTest();
  }
  
  public XmlScanningConfigTest(){
    System.out.println("Scanning context configuration test");
    
    ApplicationContext context
      = new FileSystemXmlApplicationContext(getClass().getResource("/scanningConfig.xml").toString());
    
    CurrencyTransfer obj = (CurrencyTransfer) context.getBean("currencyTransfer");
    System.out.println( obj.getCurrencyTransfer(100.0) );
  }
}

