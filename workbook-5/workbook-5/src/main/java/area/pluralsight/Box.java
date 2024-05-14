package area.pluralsight;

public class Box extends Rectangle{
    private double height;

    public Box(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    @Override
    public double getArea(){
        return 2 * (length * width) + 2 * (length * height) + 2 * ( width * height);
    }
}
