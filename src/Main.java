import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // First Register a new CashRegister
        Register cashRegister = new Register();

        // Create the products list
        PreparedProduct SandWichChicken = new PreparedProduct("Sandwich Chicken", 2.95, foodType.SANDWICH);
        PreparedProduct FrenchFries = new PreparedProduct("French Fries", 1.95, foodType.FRIED);
        PreparedProduct PastaBolognse = new PreparedProduct("Pasta Bolognse", 5.95, foodType.COOKED);
        PackageProduct Mars = new PackageProduct("Mars", 0.95);
        PackageProduct Snickers = new PackageProduct("Snicker", 0.95);

        // New way to add products
        List<Product> products = new ArrayList<>();
        products.add(SandWichChicken);
        products.add(FrenchFries);
        products.add(PastaBolognse);
        products.add(Mars);
        products.add(Snickers);

        // Adds a new prepared product to cash register (OLD WAY)
//        cashRegister.chooseProduct(SandWichChicken);
//        cashRegister.chooseProduct(SandWichChicken);
//        cashRegister.chooseProduct(SandWichChicken);
//        cashRegister.chooseProduct(FrenchFries);
//        cashRegister.chooseProduct(FrenchFries);
//        cashRegister.chooseProduct(PastaBolognse);
        // Adds a new packaged product to cash register
//        cashRegister.chooseProduct(Mars);
//        cashRegister.chooseProduct(Snickers);
//        cashRegister.chooseProduct(Snickers);

        // Initialize UI
        SwingUtilities.invokeLater(new CashRegisterUI(cashRegister, products));

        // Calculate the price of all items in the cash register
//        double total = cashRegister.calculateTotalPrice();
//        HashMap<Product, Integer> countProducts = cashRegister.getChosenProducts();

        // lambda expression
//        countProducts.forEach((product, freq) -> System.out.println(product.getName() + " is bought " + freq + " times"));

//        System.out.println(total);

        // Pay for al products
//        cashRegister.pay();
    }
}
