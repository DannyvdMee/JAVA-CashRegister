public class PreparedProduct extends Product{
    private foodType typeOfFood;

    public PreparedProduct(String name, double price, foodType typeOfFood) {
        super(name, price);
        this.typeOfFood = typeOfFood;
    }

    @Override
    public void order() {
        // Added lower case for readability
        System.out.println(typeOfFood.toString().toLowerCase() + " order sent to kitchen");
    }
}
