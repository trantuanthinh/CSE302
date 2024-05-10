package MoonCake;

public class Circle implements Shape {
    double diameter = 0;
    double radius = 0;

    public Circle(double diameter) {
        this.diameter = diameter;
        this.radius = this.diameter / 2;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
