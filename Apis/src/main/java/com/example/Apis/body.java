package com.example.Apis;

import java.sql.Timestamp;

public class body {
int id;
    Timestamp timestamp;
    double price;
    String instrument;

    public body(int id,Timestamp timestamp, double price, String instrument) {
        this.timestamp = timestamp;
        this.id = id;
        this.price = price;
        this.instrument = instrument;
    }
    public body() {
      }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
