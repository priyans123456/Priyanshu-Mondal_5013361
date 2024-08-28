public class StrategyPatternExample {

    // PaymentStrategy interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // CreditCardPayment class implementing PaymentStrategy interface
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;
        private String cvv;
        private String expiryDate;

        public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
            this.cvv = cvv;
            this.expiryDate = expiryDate;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
    }

    // PayPalPayment class implementing PaymentStrategy interface
    static class PayPalPayment implements PaymentStrategy {
        private String email;
        private String password;

        public PayPalPayment(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }

    // PaymentContext class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Main method to demonstrate the Strategy Pattern
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123", "12/23");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(250.75);

        // Pay using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(89.50);
    }
}
