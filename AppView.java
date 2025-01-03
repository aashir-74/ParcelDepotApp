package _24058824.Mummunka_Part2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AppView extends JFrame {
    private JPanel cards;
    private JButton viewParcelsButton, viewCustomersButton, addParcelButton, addCustomerButton, processCustomerButton, generateReportsButton;
    private DefaultTableModel parcelTableModel, customerTableModel;

    public AppView() {
        // JFrame properties
        setTitle("Parcel Depot Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLACK);
        JLabel headerLabel = new JLabel("Parcel Depot Management System", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // CardLayout container for switching views
        cards = new JPanel(new CardLayout());
        add(cards, BorderLayout.CENTER);

        // Add panels to the CardLayout
        cards.add(createMainPanel(), "MainPanel");
        cards.add(createViewParcelsPanel(), "ViewParcels");
        cards.add(createAddParcelPanel(), "AddParcel");
        cards.add(createAddCustomerPanel(), "AddCustomer");
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        mainPanel.setBackground(Color.DARK_GRAY);

        viewParcelsButton = createStyledButton("View Parcels");
        viewCustomersButton = createStyledButton("View Customers");
        addParcelButton = createStyledButton("Add New Parcel");
        addCustomerButton = createStyledButton("Add New Customer");
        processCustomerButton = createStyledButton("Process Customer");
        generateReportsButton = createStyledButton("Generate Reports");

        mainPanel.add(viewParcelsButton);
        mainPanel.add(viewCustomersButton);
        mainPanel.add(addParcelButton);
        mainPanel.add(addCustomerButton);
        mainPanel.add(processCustomerButton);
        mainPanel.add(generateReportsButton);

        return mainPanel;
    }

    private JPanel createViewParcelsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Parcels", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(label, BorderLayout.NORTH);

        String[] columns = {"Parcel ID", "Days in Depot", "Weight", "Dimensions", "Status"};
        parcelTableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(parcelTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = createStyledButton("Back to Main Menu");
        backButton.addActionListener(e -> switchToCard("MainPanel"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createAddParcelPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(new JLabel("Parcel ID:"));
        JTextField parcelIdField = new JTextField();
        panel.add(parcelIdField);

        panel.add(new JLabel("Weight:"));
        JTextField weightField = new JTextField();
        panel.add(weightField);

        panel.add(new JLabel("Dimensions (LxWxH):"));
        JTextField dimensionsField = new JTextField();
        panel.add(dimensionsField);

        panel.add(new JLabel("Days in Depot:"));
        JTextField daysField = new JTextField();
        panel.add(daysField);

        JButton saveButton = createStyledButton("Save");
        JButton backButton = createStyledButton("Back to Main Menu");
        backButton.addActionListener(e -> switchToCard("MainPanel"));

        panel.add(saveButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel createAddCustomerPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(new JLabel("Customer Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Parcel ID:"));
        JTextField parcelIdField = new JTextField();
        panel.add(parcelIdField);

        JButton saveButton = createStyledButton("Save");
        JButton backButton = createStyledButton("Back to Main Menu");
        backButton.addActionListener(e -> switchToCard("MainPanel"));

        panel.add(saveButton);
        panel.add(backButton);

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setBackground(new Color(179, 179, 179)); // Gray button color
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        return button;
    }

    public void switchToCard(String cardName) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, cardName);
    }

    public JButton getViewParcelsButton() {
        return viewParcelsButton;
    }

    public JButton getAddParcelButton() {
        return addParcelButton;
    }

    public JButton getViewCustomersButton() {
        return viewCustomersButton;
    }

    public JButton getAddCustomerButton() {
        return addCustomerButton;
    }

    public JButton getProcessCustomerButton() {
        return processCustomerButton;
    }

    public JButton getGenerateReportsButton() {
        return generateReportsButton;
    }

    public void displayParcels(List<Parcel> parcels) {
        parcelTableModel.setRowCount(0);
        for (Parcel parcel : parcels) {
            parcelTableModel.addRow(new Object[]{
                parcel.getParcelId(),
                parcel.getDaysInDepot(),
                parcel.getWeight(),
                parcel.getDimensions(),
                parcel.isCollected() ? "Collected" : "Waiting"
            });
        }
    }
}
