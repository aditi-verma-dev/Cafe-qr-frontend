package com.cafeqr.cafeQR.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class MenuItem {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    private String name;
    @ManyToOne
    private Category category;  

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }
    public Long getPrice(){
        return price;
    }
    public void setPrice(Long price){
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category=category; 
    }
}


