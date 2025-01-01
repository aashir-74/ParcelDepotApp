package _24058824.Mummunka_Part2;

public class Customer {
    private static int nextSequenceNumber = 1;
    private int sequenceNumber;
    private String name;
    private String parcelId;

    public Customer(String name, String parcelId) {
        this.sequenceNumber = nextSequenceNumber++;
        this.name = name;
        this.parcelId = parcelId;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getName() {
        return name;
    }

    public String getParcelId() {
        return parcelId;
    }

    @Override
    public String toString() {
        return "Customer[Sequence=" + sequenceNumber + ", Name=" + name + ", Parcel ID=" + parcelId + "]";
    }
}
