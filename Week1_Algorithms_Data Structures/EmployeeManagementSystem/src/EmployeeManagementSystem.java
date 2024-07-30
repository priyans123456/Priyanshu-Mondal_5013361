public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    // Inner class for Employee
    public static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        // Constructor
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and Setters
        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    // Constructor for EmployeeManagementSystem
    public EmployeeManagementSystem() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            expandArray();
        }
        employees[size++] = employee;
        System.out.println("Added: " + employee);
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Not found
    }

    // Method to traverse and display all employees
    public void traverseEmployees() {
        System.out.println("Employee Records:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null; // Clear last element
            System.out.println("Deleted employee with ID: " + employeeId);
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to expand the array when it is full
    private void expandArray() {
        Employee[] newArray = new Employee[employees.length * 2];
        System.arraycopy(employees, 0, newArray, 0, employees.length);
        employees = newArray;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Adding employees
        ems.addEmployee(new Employee(1, "John Doe", "Manager", 80000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Alice Johnson", "Designer", 55000));

        // Traversing employees
        ems.traverseEmployees();

        // Searching for an employee
        Employee employee = ems.searchEmployee(2);
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        ems.deleteEmployee(1);

        // Traversing employees again
        ems.traverseEmployees();
    }
}