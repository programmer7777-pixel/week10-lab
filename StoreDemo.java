interface Printable {
    void print();
}
interface Taxable {
    double TAX_RATE = 0.12;
    double calculateTax();
}
class Product implements Printable {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.printf("Product: %-15s Price: $%.2f%n", name, price);
    }
}
class TaxableProduct extends Product implements Taxable {

    public TaxableProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }

    @Override
    public void print() {
        double tax = calculateTax();
        double total = price + tax;

        System.out.printf("Product: %-15s Price: $%.2f Tax: $%.2f Total: $%.2f%n",
                name, price, tax, total);
    }
}
class DigitalProduct extends TaxableProduct {
    private String downloadUrl;

    public DigitalProduct(String name, double price, String downloadUrl) {
        super(name, price);
        this.downloadUrl = downloadUrl;
    }

    @Override
    public void print() {
        double tax = calculateTax();
        double total = price + tax;

        System.out.printf("Digital Product: %-15s Price: $%.2f Tax: $%.2f Total: $%.2f%n",
                name, price, tax, total);
        System.out.println("Download URL: " + downloadUrl);
    }
}
public class StoreDemo {
    public static void main(String[] args) {

        Printable[] items = new Printable[] {
                new Product("Notebook", 5.50),
                new TaxableProduct("Headphones", 45.00),
                new DigitalProduct("E-Book", 15.00, "http://download.com/ebook"),
                new TaxableProduct("Keyboard", 30.00),
                new Product("Pen", 2.00)
        };

        double totalTax = 0;

        for (Printable item : items) {
            item.print();

            // Check if item is Taxable
            if (item instanceof Taxable) {
                Taxable t = (Taxable) item;
                totalTax += t.calculateTax();
            }

            System.out.println();
        }

        System.out.printf("Total tax collected: $%.2f%n", totalTax);
    }
}