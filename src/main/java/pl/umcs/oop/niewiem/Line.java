package pl.umcs.oop.niewiem;

import javafx.scene.paint.Color;

public class Line {
    private double xb;
    private double yb;
    private double xe;
    private double ye;
    private String color;

    public Line(String color, double xb, double yb, double xe, double ye) {
        this.color = color;
        this.xb = xb;
        this.xe = xe;
        this.yb = yb;
        this.ye = ye;
    }

    public String getColor() {
        return color;
    }

    public double getXb() {
        return xb;
    }

    public double getXe() {
        return xe;
    }

    public double getYb() {
        return yb;
    }

    public double getYe() {
        return ye;
    }
}
