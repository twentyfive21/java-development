package area.pluralsight;

public class Square extends Rectangle{

    public Square (double length, double width){
        super(length, width);
    }

    @Override
    public double getArea(){
        if(length == width){
            return length * width;
        }
        return 0;
    }

}
