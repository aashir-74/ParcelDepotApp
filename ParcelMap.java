package _24058824.Mummunka_Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ParcelMap {
    private HashMap<String, Parcel> parcelMap;

    public ParcelMap() {
        this.parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelId(), parcel);
    }

    public Parcel findParcelById(String parcelId) {
        return parcelMap.get(parcelId);
    }

    public List<Parcel> getParcels() {
        return new ArrayList<>(parcelMap.values());
    }

    public void markParcelAsCollected(String parcelId) {
        Parcel parcel = parcelMap.get(parcelId);
        if (parcel != null) {
            parcel.setCollected(true);
        }
    }

    // Updated method to load parcels from a CSV file
    public void loadParcels(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) { // Expecting Parcel ID, Days, Weight, Length, Width, Height
                    String parcelId = data[0];
                    int daysInDepot = Integer.parseInt(data[1]);
                    double weight = Double.parseDouble(data[2]);
                    // Combine Length, Width, Height into a single dimensions string (e.g., "LxWxH")
                    String dimensions = data[3] + "x" + data[4] + "x" + data[5];

                    // Create the Parcel object and add it to the parcelMap
                    Parcel parcel = new Parcel(parcelId, daysInDepot, weight, dimensions);
                    addParcel(parcel);
                } else {
                    System.out.println("Invalid parcel data: " + line);
                }
            }
        }
    }
}
