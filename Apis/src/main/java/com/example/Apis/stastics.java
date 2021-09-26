package com.example.Apis;

public class stastics {

    int count = 0;
    double avg=0;

    double max;
    double min;

    public stastics(int count, double avg, double max, double min) {
        this.count = count;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }
    public stastics() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
