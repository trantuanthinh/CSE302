package MoonCake;

public class Rectangle implements Shape {
    double height = 0;
    double width = 0;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }
}
