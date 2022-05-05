package com.mindtree.milestone3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {
    @Id
    private String name;
    private int id;
    private double price;
    
   
    public Mobile() {
    }

    public Mobile(int id,String name, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}