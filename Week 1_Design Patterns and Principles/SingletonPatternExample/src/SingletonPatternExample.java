public class SingletonPatternExample {

    // Singleton class
    public static class Logger {
        // Step 1: Private static instance of the same class
        private static Logger instance;

        // Step 2: Private constructor to prevent instantiation
        private Logger() {
            // Private constructor to prevent instantiation
            System.out.println("Logger initialization done!");
        }

        // Step 3: Public static method to provide the single instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Method to log messages
        public void log(String message) {
            System.out.println("Log message: " + message);
        }
    }

    // Main method to test the Singleton implementation
    public static void main(String[] args) {
        // Attempt to create multiple instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test if both references point to the same instance
        System.out.println(logger1 == logger2); // Should print 'true'

        // Test logging method
        logger1.log("This is a log message.");
        logger2.log("This is another log message.");
    }
}
