package com.cafeqr.cafeQR.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class CafeTable{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tableNumber;


    public Long getId(){
      return id;
    }

     public void setId(long id){
        this.id= id;
    }
     
    public int getTableNumber(){
         return tableNumber;
    }
    public void setTableNumber(int tableNumber){
        this.tableNumber= tableNumber;
    }
}