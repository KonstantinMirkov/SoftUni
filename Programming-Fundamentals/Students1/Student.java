package com.JavaFundamentals.Students1;

public class Student {
    private String firstname;
    private String lastname;
    private int age;
    private String hometown;

    public Student(String firstname,String lastname, int age, String hometown) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.hometown = hometown;


    }



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
    public String getHometown (){
        return this.hometown;
    }
}
