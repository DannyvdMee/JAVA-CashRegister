import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CashRegisterUI implements Runnable {
    private JFrame frame;
    private Register register;
    private List<Product> products;

    public CashRegisterUI(JFrame frame, Register register, List<Product> products) {
        this.frame = frame;
        this.register = register;
        this.products = products;
    }

    public CashRegisterUI(Register cashRegister, List<Product> products) {
        this.register = cashRegister;
        this.products = products;
    }

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout(10, 10));

        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(products.size(), 1));

        JTextArea chosenProductsSummary = new JTextArea();
        chosenProductsSummary.setPreferredSize(new Dimension(150, 200));
        chosenProductsSummary.setBackground(Color.lightGray);
        JLabel totalPrice = new JLabel();
        totalPrice.setText("Total: ");
        JButton payButton = new JButton("Pay!");

        JPanel cashRegisterDisplay = new JPanel();
        cashRegisterDisplay.setLayout(new GridLayout(3, 1));
        cashRegisterDisplay.add(chosenProductsSummary);
        cashRegisterDisplay.add(totalPrice);
        cashRegisterDisplay.add(payButton);

        payButton.addActionListener(e -> {
            chosenProductsSummary.setText("");
            totalPrice.setText("Totaal: ");
            register.pay();
        });

        for (Product product : products) {
            JButton productButton = new JButton(product.getName() + " (" + product.getPrice() + ")");
            productPanel.add(productButton);
            productButton.addActionListener(new ProductButtonListener(register, chosenProductsSummary, totalPrice, product));
        }

        contentPane.add(productPanel, BorderLayout.WEST);
        contentPane.add(cashRegisterDisplay, BorderLayout.EAST);
    }


    public JFrame getFrame() {
        return frame;
    }
}
