package org.example;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
    @Override
    public void compile() {
        System.out.println("compiled in laptop");
    }
}
