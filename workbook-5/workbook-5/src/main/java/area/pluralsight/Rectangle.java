package area.pluralsight;

public class Rectangle extends Shape{
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return  length * width;
    }
}
