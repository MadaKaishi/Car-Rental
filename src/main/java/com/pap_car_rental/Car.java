package com.pap_car_rental;

import java.sql.Date;

public class Car {
    final int id;
    final String Car_type;
    final String Brand;
    final int Cost;
    final String Model;


    Car(int id, String Car_type, String Brand, int Cost, String Model) {
        this.id = id;
        this.Car_type = Car_type;
        this.Brand = Brand;
        this.Cost = Cost;
        this.Model = Model;

    }
}
