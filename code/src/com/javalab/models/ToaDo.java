package com.javalab.models;

public class ToaDo {
    private double x;
    private double y;
    private double z;

    public ToaDo() {
    }

    public ToaDo(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public void setXYZ(double x,double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double khoangCach(ToaDo t) {
        return Math.sqrt((t.x - this.x)*(t.x - this.x)+(t.y - this.y)*(t.y - this.y)+(t.z - this.z)*(t.z - this.z));
    }
}
