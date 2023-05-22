package ru.irenademchenkova.dao_layer.entities;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private int id;
    private Date date;
    private int customer_id;
    private String product_name;
   private int amount;

    public Order(int id, Date date, int customer_id, String product_name, int amount) {
        this.id = id;
        this.date = date;
        this.customer_id = customer_id;
        this.product_name = product_name;
        this.amount = amount;
    }
}
