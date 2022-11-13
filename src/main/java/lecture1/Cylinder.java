package lecture1;

import java.util.Objects;

public class Cylinder implements Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    //no setter `cause the cylinder is supposed to be created with these parameters and not to change them afterwards

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getVolume() {
        return Math.PI*radius*radius*height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.radius, radius) == 0 && Double.compare(cylinder.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, height);
    }

    @Override
    public String toString() {
        return "Cylinder - volume " +
                getVolume();
    }
}
