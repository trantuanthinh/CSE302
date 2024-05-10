package MoonCake;

public class MoonCake {
    Shape shape;
    double price;

    public MoonCake(Shape shape, double price) {
        this.shape = shape;
        this.price = price;
    }

    double getPrice() {
        return this.price;
    };
}
