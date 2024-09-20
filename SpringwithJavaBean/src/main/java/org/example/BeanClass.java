package org.example;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= "org.example")
public class BeanClass {
   @Bean
    public Student student(){
       return new Student(2);
   }
}
