package com.JavaAdvanced.ExamPreparation.university;

import java.util.*;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder builder = new StringBuilder();
        if (this.students.size() < capacity) {
            if (this.students.contains(student)) {
                builder.append("Student is already in the com.JavaAdvanced.ExamPreparation.university");
            } else {
                this.students.add(student);
                builder.append("Added student ")
                        .append(student.firstName)
                        .append(" ")
                        .append(student.lastName);
            }
        } else {
            builder.append("No seats in the com.JavaAdvanced.ExamPreparation.university");
        }
        return builder.toString();
    }


    public String dismissStudent(Student student) {
        StringBuilder builder = new StringBuilder();
        if (this.students.contains(student)) {
            builder
                    .append("Removed student ")
                    .append(student.firstName)
                    .append(" ")
                    .append(student.lastName);
            this.students.remove(student);
        } else {
            builder
                    .append("Student not found");
        }
        return builder.toString();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.firstName.equals(firstName) && student.lastName.equals(lastName)) {
                return student;
            }
        }
        return null;
        //return this.students
        //                .stream()
        //                .filter(student -> student.firstName.equals(firstName) && student.lastName.equals(lastName))
        //                .findFirst()
        //                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Student student : students) {
            builder.append("==Student: First Name = ").append(student.firstName)
                    .append(", Last Name = ").append(student.lastName).append(", Best Subject = ")
                    .append(student.bestSubject).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
