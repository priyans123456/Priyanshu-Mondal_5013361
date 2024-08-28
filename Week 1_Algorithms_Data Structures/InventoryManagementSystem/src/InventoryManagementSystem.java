import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        Product removedProduct = inventory.remove(productId);
        if (removedProduct != null) {
            System.out.println("Deleted: " + removedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Adding products
        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 20, 499.99);
        Product product3 = new Product(3, "Tablet", 15, 299.99);

        ims.addProduct(product1);
        ims.addProduct(product2);
        ims.addProduct(product3);

        // Display inventory
        ims.displayInventory();

        // Updating a product
        Product updatedProduct1 = new Product(1, "Laptop", 8, 979.99);
        ims.updateProduct(updatedProduct1);

        // Display inventory
        ims.displayInventory();

        // Deleting a product
        ims.deleteProduct(2);

        // Display inventory
        ims.displayInventory();

        // Retrieving a product
        Product retrievedProduct = ims.getProduct(1);
        if (retrievedProduct != null) {
            System.out.println("Retrieved: " + retrievedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }
}

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

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
