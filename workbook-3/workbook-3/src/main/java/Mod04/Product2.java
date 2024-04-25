package Mod04;
// this class is the product class that holds sku, product name, price, and department.

public class Product2 {

    private float price;
    private String sku;
    private String name;
    private String department;

    public Product2(float price, String sku, String name, String department) {
        this.price = price;
        this.sku = sku;
        this.name = name;
        this.department = department;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        String formattedPrice = String.format("%.2f", price);
        return "Product2{" +
                "price=" + formattedPrice +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
