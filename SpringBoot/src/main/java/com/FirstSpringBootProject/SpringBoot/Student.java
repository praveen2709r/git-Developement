package com.FirstSpringBootProject.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Autowired
    Developer developer;
    void activity(){
        developer.code();
        System.out.println("Study");
    }
}
