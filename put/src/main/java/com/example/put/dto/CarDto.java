package com.example.put.dto;

public class CarDto {
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    private String name;
    private String carNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", carNumber=" + carNumber +
                '}';
    }
}
