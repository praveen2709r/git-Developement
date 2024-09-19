package org.example;

public class Student {
    private int age;
    private Computer com;


    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        System.out.println("setter method will be called when we use property tag");
        this.age = age;
    }
    public Computer getCom() {
        return com;
    }
    public void setCom(Computer com) {
        this.com = com;
    }
    public Student(){
        System.out.println("Constructor will be called when spring creates a bean");
    }
    void code(){
        com.compile();
        System.out.println("I'm Coding..");
    }
}
