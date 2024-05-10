package MoonCake;

public class main {
    public static void main(String[] args) {
        MoonCake circle = new MoonCake(new Circle(5), 4000);
        MoonCake rectangle = new MoonCake(new Rectangle(6, 4), 5000);
        String result = compareCheaper(circle, rectangle);
        System.out.println("The cheaper option is: " + result);
    }

    public static String compareCheaper(MoonCake circle, MoonCake rectangle) {
        double circleArea = circle.shape.getArea();
        double rectangleArea = rectangle.shape.getArea();
        double pricePerCircleArea = circle.price / circleArea;
        double pricePerRectangleArea = rectangle.price / rectangleArea;
        return pricePerCircleArea > pricePerRectangleArea ? "Rectangle" : "Circle";
    }
}
