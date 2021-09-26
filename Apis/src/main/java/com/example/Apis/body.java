package com.example.Apis;

import java.sql.Timestamp;

public class body {

    Timestamp timestamp;
    double price;
    String instrument;

    public body(Timestamp timestamp, double price, String instrument) {
        this.timestamp = timestamp;
        this.price = price;
        this.instrument = instrument;
    }
    public body() {
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
