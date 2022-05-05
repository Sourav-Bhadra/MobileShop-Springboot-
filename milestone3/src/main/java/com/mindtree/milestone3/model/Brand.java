package com.mindtree.milestone3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Brand {
    @Id
    private String name;
    private int id;
   
 

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Mobile.class)
    @JoinColumn(name = "brand_id", referencedColumnName = "name")
    private List<Mobile> mobiles;

    public Brand(String name,int id) {
        this.name = name;
        this.id=id;
    }

    public Brand() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    @Override
    public String toString() {
        return "Brand [id=" + id + ", name=" + name + "]";
    }
}