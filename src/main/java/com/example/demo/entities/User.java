package com.example.demo.entities;
import org.springframework.data.annotation.Id;

public class User {

// id in mongoDB are stored as objectIds (uuid)
    @Id
    private String id;
    private String name;
    private int age;

    // best practice to have a empty constructor.
    public User(){
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
