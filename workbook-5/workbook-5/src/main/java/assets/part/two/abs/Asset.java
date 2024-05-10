package assets.part.two.abs;

public abstract class Asset {

    // asset members
    private String description;
    private String dateAcquired;
    private double originalCost;

    // constructor
    public Asset(String description, String dateAcquired, double originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    // getters and setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }
    // derived method
    // no {} for abstract method they cannot have a body
    public abstract double getValue();

    @Override
    public String toString() {
        return "Asset{" +
                "description='" + description + '\'' +
                ", dateAcquired='" + dateAcquired + '\'' +
                ", originalCost=" + originalCost +
                '}';
    }

}
