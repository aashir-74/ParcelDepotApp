package _24058824.Mummunka_Part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue;

    public QueueOfCustomers() {
        this.customerQueue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer dequeue() {
        return customerQueue.poll();
    }

    public List<Customer> getQueueAsList() {
        return new LinkedList<>(customerQueue);
    }

    public void loadCustomers(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0];
                    String parcelId = data[1];

                    Customer customer = new Customer(name, parcelId);
                    addCustomer(customer);
                } else {
                    System.out.println("Invalid customer data: " + line);
                }
            }
        }
    }
}
