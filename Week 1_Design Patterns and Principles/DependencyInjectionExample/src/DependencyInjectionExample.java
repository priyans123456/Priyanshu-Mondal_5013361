public class DependencyInjectionExample {

    // Customer class
    static class Customer {
        private String id;
        private String name;
        private String email;

        public Customer(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        // Getters and toString method
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
        }
    }

    // CustomerRepository interface
    interface CustomerRepository {
        Customer findCustomerById(String id);
    }

    // CustomerRepositoryImpl class implementing CustomerRepository interface
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(String id) {
            // For demonstration, returning a dummy customer.
            // In a real application, you would query a database here.
            return new Customer(id, "Priyanshu", "priy123@example.com");
        }
    }

    // CustomerService class
    static class CustomerService {
        private CustomerRepository customerRepository;

        // Constructor injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(String id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Main method to demonstrate Dependency Injection
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject CustomerRepositoryImpl into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use CustomerService to find a customer
        Customer customer = customerService.getCustomerById("1");

        // Display the customer details
        System.out.println(customer);
    }
}

