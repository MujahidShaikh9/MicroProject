package com.student.app.model;

public class StudentModel {

    private String name;
    private String city;

    public StudentModel(String name, String city, String gender, int phone, int age) {
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.phone = phone;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    private String gender;
    private int phone, age;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

}