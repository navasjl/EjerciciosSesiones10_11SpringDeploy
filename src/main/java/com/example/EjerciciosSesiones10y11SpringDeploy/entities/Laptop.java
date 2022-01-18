package com.example.EjerciciosSesiones10y11SpringDeploy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String cpu;
    private Integer ram;
    private Integer hardDisk;
    private Double screen;
    private Double price;
    private boolean oled;

    //constructores

    public Laptop() {
    }

    public Laptop(Long id, String brand, String cpu, Integer ram, Integer hardDisk, Double screen, Double price, boolean oled) {
        this.id = id;
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.screen = screen;
        this.price=price;
        this.oled = oled;
    }

    //getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Integer hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Double getScreen() {
        return screen;
    }

    public void setScreen(Double screen) {
        this.screen = screen;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public boolean isOled() {
        return oled;
    }

    public void setOled(boolean oled) {
        this.oled = oled;
    }

    //toString

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", hardDisk=" + hardDisk +
                ", screen=" + screen +
                ", price=" + price +
                ", oled=" + oled +
                '}';
    }
}
