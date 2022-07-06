package com.himanshu.learningSpringBoot;


//(1) Write a program to demonstrate Tightly Coupled code.

// Coupling basically refers to the extent of knowledge one class knows about the other class.

class First{
    Second second;
    public First() {
        second = new Second();
    }
    public void display(){
        System.out.println("First class");
        second.display();
    }
}

class Second{

    public Second() {
    }
    public void display(){
        System.out.println("Second class");
    }
}

public class QuestionOne {
    public static void main(String[] args) {
        First first = new First();
        first.display();

    }
}
