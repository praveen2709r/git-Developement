package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(BeanClass.class);
        Student student=context.getBean(Student.class);
        student.code();
        System.out.println(student.getAge());
    }
}