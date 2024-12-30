package _24058824.Mummunka_Part2;

public class Parcel {
    private String parcelId;
    private int daysInDepot;
    private double weight;
    private String dimensions; // Stored as "LxWxH"
    private boolean collected;

    public Parcel(String parcelId, int daysInDepot, double weight, String dimensions) {
        this.parcelId = parcelId;
        this.daysInDepot = daysInDepot;
        this.weight = weight;
        this.dimensions = dimensions;
        this.collected = false; // Default state
    }

    public String getParcelId() {
        return parcelId;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    @Override
    public String toString() {
        return "Parcel[ID=" + parcelId + ", Days=" + daysInDepot + ", Weight=" + weight + ", Dimensions=" + dimensions + ", Collected=" + collected + "]";
    }
}
