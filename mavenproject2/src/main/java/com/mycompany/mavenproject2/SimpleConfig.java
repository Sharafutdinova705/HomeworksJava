/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author guzel
 */
@Configuration
public class SimpleConfig {

   @Bean 
   public CurrencyTransfer currencyTransfer(){
      return new CurrencyTransfer();
   }
}
