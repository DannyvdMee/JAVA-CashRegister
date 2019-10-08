import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ProductButtonListener implements ActionListener {

    private Register register;
    private JTextArea chosenProductsSummary;
    private JLabel totalPriceLabel;
    private Product product;

    public ProductButtonListener(Register register, JTextArea chosenProductsSummary, JLabel totalPriceLabel, Product product) {
        this.register = register;
        this.chosenProductsSummary = chosenProductsSummary;
        this.totalPriceLabel = totalPriceLabel;
        this.product = product;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<Product, Integer> productCount = register.getChosenProducts();
        String text = "";

        for (Product product : productCount.keySet()) {
            int freq = productCount.get(product);
            text += freq + " x " + product.getName() + " " + (freq * product.getPrice());
        }

        chosenProductsSummary.setText(text);
    }
}
