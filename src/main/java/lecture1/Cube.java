package lecture1;

import java.util.Objects;

public class Cube implements Shape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    //no setter `cause the cube is supposed to be created with the side and not to change it afterwards

    public double getSide() {
        return side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        return "Cube - volume " +
                getVolume();
    }
}
