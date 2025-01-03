package _24058824.Mummunka_Part2;

import java.util.List;

public class AppController {
    private ParcelMap parcelMap;
    private QueueOfCustomers queueOfCustomers;
    private Log log;
    private AppView appView;

    public AppController(ParcelMap parcelMap, QueueOfCustomers queueOfCustomers, Log log, AppView appView) {
        this.parcelMap = parcelMap;
        this.queueOfCustomers = queueOfCustomers;
        this.log = log;
        this.appView = appView;

        setupActionListeners();
    }

    private void setupActionListeners() {
        appView.getViewParcelsButton().addActionListener(e -> viewParcels());
        appView.getAddParcelButton().addActionListener(e -> addParcel());
        appView.getViewCustomersButton().addActionListener(e -> viewCustomers());
        appView.getAddCustomerButton().addActionListener(e -> addCustomer());
        appView.getProcessCustomerButton().addActionListener(e -> processCustomer());
        appView.getGenerateReportsButton().addActionListener(e -> generateReports());
    }

    private void viewParcels() {
        appView.displayParcels(parcelMap.getParcels()); // Update the parcels table
        appView.switchToCard("ViewParcels"); // Switch to the "View Parcels" panel
    }

    private void addParcel() {
        appView.switchToCard("AddParcel"); // Switch to the "Add Parcel" form
    }

    private void viewCustomers() {
        appView.displayCustomers(queueOfCustomers.getQueueAsList()); // Update the customers table
        appView.switchToCard("ViewCustomers"); // Switch to the "View Customers" panel
    }

    private void addCustomer() {
        appView.switchToCard("AddCustomer"); // Switch to the "Add Customer" form
    }

    private void processCustomer() {
        Customer nextCustomer = queueOfCustomers.dequeue();
        if (nextCustomer == null) {
            appView.showMessage("No customers in the queue.");
            return;
        }

        Parcel parcel = parcelMap.findParcelById(nextCustomer.getParcelId());
        if (parcel == null || parcel.isCollected()) {
            log.addEvent("Failed to process customer: " + nextCustomer.getName() + ". Parcel not found or already collected.");
            appView.showMessage("No valid parcel for customer: " + nextCustomer.getName());
            return;
        }

        Worker worker = new Worker();
        double fee = worker.processCustomer(nextCustomer, parcel);
        log.addEvent("Processed customer: " + nextCustomer.getName() + ", collected parcel: " + parcel.getParcelId() + ", fee: $" + fee);
        appView.showMessage("Customer processed successfully! Fee: $" + fee);

        viewParcels();
        viewCustomers();
    }

    private void generateReports() {
        log.writeLogToFile("DepotLog.txt");
        appView.showMessage("Report generated and saved to DepotLog.txt.");
    }
}
