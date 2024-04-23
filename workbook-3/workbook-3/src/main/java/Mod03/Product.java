package Mod03;

// this class is used to create a project object and used in search Inventory

public class Product {

    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String formattedPrice = String.format("%.2f", price);
        return "Product id= " + id +
                "\nItem name= " + name  +
                "\nItem price= $" + formattedPrice +"\n";
    }


}
