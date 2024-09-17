package org.example;

import javax.swing.*;

public class Student {
    private int marks;
    private Laptop laptop;

    public Student(int marks) {
        this.marks = marks;

    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void message(){
        laptop.code();
        System.out.println("Student studies");
    }
}
