package org.example.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    int id;
    String brand;
    String model;
    int ram;

    public Laptop() {
    }


    public Laptop(int id,String brand, String model, int ram) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
