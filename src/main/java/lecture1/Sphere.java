package lecture1;

import java.util.Objects;

public class Sphere implements Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    //no setter `cause the sphere is supposed to be created with the radius and not to change it afterwards

    public double getRadius() {
        return radius;
    }

    @Override
    public double getVolume() {
        return 4/3*Math.PI*Math.pow(radius, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Sphere - volume " +
                getVolume();
    }
}
