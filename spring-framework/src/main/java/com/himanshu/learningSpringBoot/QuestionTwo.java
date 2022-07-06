package com.himanshu.learningSpringBoot;

//(2) Write a program to demonstrate Loosely Coupled code.

interface Print{
    void display();
}

class Primary{
    Print print;
    public Primary(Print print){
        this.print = print;
    }
    public void display(){
        System.out.println("Class primary");
        print.display();
    }

}

class Secondary implements Print{
    public Secondary(){

    }
    public void display(){
        System.out.println("Secondary class");
    }
}

public class QuestionTwo {
    public static void main(String[] args) {
        Print secondary = new Secondary();
        Primary primary = new Primary(secondary);
        primary.display();
    }
}