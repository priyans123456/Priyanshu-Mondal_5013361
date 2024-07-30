import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class SearchFunctions {

    // Linear search to find a product by name
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary search to find a product by name
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(name);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product(1, "Laptop", 10, 999.99),
            new Product(2, "Smartphone", 20, 499.99),
            new Product(3, "Tablet", 15, 299.99),
            new Product(4, "Headphones", 25, 199.99),
            new Product(5, "Smartwatch", 30, 199.99)
        };

        // Perform linear search
        String searchName1 = "Tablet";
        Product result1 = linearSearch(products, searchName1);
        System.out.println("Linear Search Result: " + result1);

        // Sort the array for binary search
        Arrays.sort(products, (a, b) -> a.getProductName().compareToIgnoreCase(b.getProductName()));

        // Perform binary search
        String searchName2 = "Smartwatch";
        Product result2 = binarySearch(products, searchName2);
        System.out.println("Binary Search Result: " + result2);
    }
}
