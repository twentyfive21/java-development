package hotelOperations;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty, boolean isAvailable) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        this.isAvailable = isAvailable;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void checkIn(){
        isDirty = true;
        isOccupied = true;
        isAvailable = false;
    }
    public void checkOut(){
        cleanRoom();
        isAvailable = true;
    }
    public void cleanRoom(){
        isDirty = false;
        isOccupied = false;
        isAvailable = true;
    }
}

/*
 - assertEquals(expected, actual) - compares for equality
− assertNotEquals(expected, actual) -- compares values and fails it equal
− assertArrayEquals(expectedArray, actualArray) - compares size & values of all elements in 2 arrays
− assertTrue(booleanValue) - checks if is true
− assertFalse(booleanValue) - checks if is false */