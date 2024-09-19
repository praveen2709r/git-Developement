package org.example;

public class Student {
    private int age;
    private Laptop laptop;

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        System.out.println("setter method will be called when we use property tag");
        this.age = age;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
//    public Student(){
//        System.out.println("Constructor will be called when spring creates a bean");
//    }
    void code(){
        laptop.compile();
        System.out.println("I'm Coding..");
    }
}
