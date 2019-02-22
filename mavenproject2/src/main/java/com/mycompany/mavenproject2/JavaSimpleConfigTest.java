/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author guzel
 */
public class JavaSimpleConfigTest {

  public static void main(String[] args) {
    System.out.println("Java config context configuration test");
    
    ApplicationContext context
      = new AnnotationConfigApplicationContext(SimpleConfig.class);
    
    CurrencyTransfer obj = (CurrencyTransfer) context.getBean("currencyTransfer");
    System.out.println( obj.getCurrencyTransfer(25.0) );
  }
}