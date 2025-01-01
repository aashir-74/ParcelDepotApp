package _24058824.Mummunka_Part2;

import javax.swing.SwingUtilities;

public class Manager {

    public static void main(String[] args) {
        // Step 1: Initialize core components
        ParcelMap parcelMap = new ParcelMap(); // Manages parcels
        QueueOfCustomers queueOfCustomers = new QueueOfCustomers(); // Manages customer queue
        Log log = Log.getInstance(); // Singleton log instance

        // Step 2: Load initial data (example: from CSV files)
        try {
            parcelMap.loadParcels("Parcels.csv"); // Ensure a valid file path
            queueOfCustomers.loadCustomers("Custs.csv"); // Ensure a valid file path
            System.out.println("Initial data loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading initial data: " + e.getMessage());
            return; // Exit to avoid running with incomplete data
        }

        // Step 3: Set up the GUI and link it with the controller
        SwingUtilities.invokeLater(() -> {
            AppView appView = new AppView(); // The GUI
            AppController appController = new AppController(parcelMap, queueOfCustomers, log, appView); // Controller links everything
            appView.setVisible(true); // Show the GUI
        });
    }
}
