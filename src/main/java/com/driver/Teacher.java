package com.driver;

public class Teacher {

    private String name;
    private int numberOfStudents;
    private int age;

    public Teacher(){}

    public Teacher(String Name, int NoOfStudents, int Age){
        this.name = Name;
        this.numberOfStudents = NoOfStudents;
        this.age = Age;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public int getNumberOfStudents() {return numberOfStudents;}
    public void setNumberOfStudents(int numberOfStudents) {this.numberOfStudents = numberOfStudents;}
}