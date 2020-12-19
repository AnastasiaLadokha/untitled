package ua.stu;

import java.awt.*;
import java.util.Objects;

public class Pokupka {

    private Point coordinate;

    public Pokupka(Point point) {
        this.coordinate = point;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokupka pokupka = (Pokupka) o;
        return Objects.equals(coordinate, pokupka.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }

    @Override
    public String toString() {
        return "Pokupka{" +
                "coordinate=" + coordinate +
                '}';
    }
}
