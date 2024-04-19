package it.academy.xmlparser.dto;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Car {

    public String category;

    public String model;
    public Integer currency;
    public Integer year;



    public static void main(String[] args) {
        List<Car> carstore = new ArrayList<>();
        carstore.add(new Car("truck",
                "Scania R 77",
                200000,
                2005));

        carstore.add(new Car("sedan",
                "Ford Focus",
                20000,
                2012));



    }
}
