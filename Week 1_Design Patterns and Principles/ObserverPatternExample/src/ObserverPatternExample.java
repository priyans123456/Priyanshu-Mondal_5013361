import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    // Stock interface
    interface Stock {
        void register(Observer o);
        void deregister(Observer o);
        void notifyObservers();
    }

    // StockMarket class implementing Stock interface
    static class StockMarket implements Stock {
        private List<Observer> observers;
        private double price;

        public StockMarket() {
            observers = new ArrayList<>();
        }

        @Override
        public void register(Observer o) {
            observers.add(o);
        }

        @Override
        public void deregister(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(price);
            }
        }

        public void setPrice(double price) {
            this.price = price;
            notifyObservers();
        }
    }

    // Observer interface
    interface Observer {
        void update(double price);
    }

    // MobileApp class implementing Observer interface
    static class MobileApp implements Observer {
        private String name;

        public MobileApp(String name) {
            this.name = name;
        }

        @Override
        public void update(double price) {
            System.out.println(name + " received stock price update: " + price);
        }
    }

    // WebApp class implementing Observer interface
    static class WebApp implements Observer {
        private String name;

        public WebApp(String name) {
            this.name = name;
        }

        @Override
        public void update(double price) {
            System.out.println(name + " received stock price update: " + price);
        }
    }

    // Main method to demonstrate the Observer Pattern
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setPrice(100.00);
        System.out.println();

        stockMarket.setPrice(105.50);
        System.out.println();

        stockMarket.deregister(mobileApp);

        stockMarket.setPrice(110.75);
    }
}
