public class PackageProduct extends Product {

    public PackageProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void order() {
        System.out.println("Packaged product served");
    }
}
