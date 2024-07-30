
// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adapter Classes
class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment through PayPal: $" + amount);
    }
}

class StripeGateway {
    public void charge(double amount) {
        System.out.println("Processing payment through Stripe: $" + amount);
    }
}

// Adapter Classes
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.charge(amount);
    }
}

// Main Class to Test Adapters
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Using PayPal through the adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.0);

        // Using Stripe through the adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(200.0);
    }
}
