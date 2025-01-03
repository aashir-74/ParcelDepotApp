package _24058824.Mummunka_Part2;

public class Worker {

    public double processCustomer(Customer customer, Parcel parcel) {
        double fee = calculateFee(parcel);
        parcel.setCollected(true);
        return fee;
    }

    private double calculateFee(Parcel parcel) {
        double fee = parcel.getWeight() * 2.0 + parcel.getDaysInDepot() * 0.5;

        if (parcel.getParcelId().startsWith("X")) {
            fee *= 0.9; // 10% discount for parcels with ID starting with 'X'
        }

        return fee;
    }
}
