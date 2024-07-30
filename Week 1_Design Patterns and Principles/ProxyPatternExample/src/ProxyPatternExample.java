public class ProxyPatternExample {
    
    // Image interface
    interface Image {
        void display();
    }

    // RealImage class implementing Image interface
    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk(fileName);
        }

        private void loadFromDisk(String fileName) {
            System.out.println("Loading " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }
    }

    // ProxyImage class implementing Image interface
    static class ProxyImage implements Image {
        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    // Main method to demonstrate the Proxy Pattern
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // Image will be loaded from disk
        image.display();
        System.out.println("");

        // Image will not be loaded from disk
        image.display();
    }
}
