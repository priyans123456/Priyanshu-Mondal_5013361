public class BuilderPatternExample {

    // Product class
    public static class Computer {
        // Required attributes
        private String CPU;
        private int RAM;
        private int storage;
        // Optional attributes
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        // Private constructor
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        // Getters
        public String getCPU() {
            return CPU;
        }

        public int getRAM() {
            return RAM;
        }

        public int getStorage() {
            return storage;
        }

        public boolean isGraphicsCardEnabled() {
            return isGraphicsCardEnabled;
        }

        public boolean isBluetoothEnabled() {
            return isBluetoothEnabled;
        }

        // Builder Class
        public static class Builder {
            // Required attributes
            private String CPU;
            private int RAM;
            private int storage;
            // Optional attributes
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            // Constructor for required attributes
            public Builder(String CPU, int RAM, int storage) {
                this.CPU = CPU;
                this.RAM = RAM;
                this.storage = storage;
            }

            public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Test class
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder("Intel i7", 16, 512)
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer computer2 = new Computer.Builder("AMD Ryzen 5", 8, 256)
                .setGraphicsCardEnabled(false)
                .setBluetoothEnabled(true)
                .build();

        System.out.println("Computer 1: CPU = " + computer1.getCPU() +
                           ", RAM = " + computer1.getRAM() +
                           "GB, Storage = " + computer1.getStorage() +
                           "GB, Graphics Card = " + computer1.isGraphicsCardEnabled() +
                           ", Bluetooth = " + computer1.isBluetoothEnabled());

        System.out.println("Computer 2: CPU = " + computer2.getCPU() +
                           ", RAM = " + computer2.getRAM() +
                           "GB, Storage = " + computer2.getStorage() +
                           "GB, Graphics Card = " + computer2.isGraphicsCardEnabled() +
                           ", Bluetooth = " + computer2.isBluetoothEnabled());
    }
}
