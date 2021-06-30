package com.JavaAdvanced.DefiningClasses.OpinionPoll;

public class PersonalInfo {
    private String name;
    private int age;

    //конструктор
    public PersonalInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
