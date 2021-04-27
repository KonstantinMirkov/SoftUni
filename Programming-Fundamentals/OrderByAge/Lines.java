package com.JavaFundamentals.OrderByAge;

public class Lines {
    private String name;
    private String id;
    private int age;

    Lines(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
