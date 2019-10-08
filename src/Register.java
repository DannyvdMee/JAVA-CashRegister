import java.util.ArrayList;
import java.util.HashMap;

public class Register {
    ArrayList<Product> chosenProducts = new ArrayList<>();

    public void chooseProduct(Product product) {
        chosenProducts.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0.00;

        for (Product chozenProduct : chosenProducts) {
            total += chozenProduct.getPrice();
        }

        return total;
    }

    public void pay() {
        for (Product chozenProduct : chosenProducts) {
            chozenProduct.order();
        }

        // Empties only the values
        chosenProducts.clear();
    }

    public HashMap<Product, Integer> getChosenProducts() {
        HashMap<Product, Integer> productCount = new HashMap<>();

        for (Product chosenProduct : chosenProducts) {
            if (productCount.containsKey(chosenProduct)) {
                int freq = productCount.get(chosenProduct);
                freq++;
                productCount.put(chosenProduct, freq);
            } else {
                productCount.put(chosenProduct, 1);
            }

//            Can be shorter like:
//            int freq = (productCount.containsKey(chosenProduct)) ? productCount.get(chosenProduct) :
//                    productCount.put(chosenProduct, freq);
        }

        return productCount;
    }
}
