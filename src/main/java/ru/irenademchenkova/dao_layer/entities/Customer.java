package ru.irenademchenkova.dao_layer.entities;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Customer {
    private  int id;
    private String name;
    private String surname;
    private int age;
    private String phone_number;

    public Customer(int id, String name, String surname, int age, String phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
