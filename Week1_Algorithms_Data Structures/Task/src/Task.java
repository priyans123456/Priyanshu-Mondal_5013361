public class Task {
    private int taskId;
    private String taskName;
    private String status;
    private Task next; // To be used for the linked list implementation

    // Constructor
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null; // Initially, the next node is null
    }

    // Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // Task Management System class definition
    private static class TaskManagementSystem {
        private Task head;

        // Method to add a task
        public void addTask(Task task) {
            Task newNode = new Task(task.getTaskId(), task.getTaskName(), task.getStatus());
            if (head == null) {
                head = newNode;
            } else {
                Task current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Added: " + task);
        }

        // Method to search for a task by ID
        public Task searchTask(int taskId) {
            Task current = head;
            while (current != null) {
                if (current.getTaskId() == taskId) {
                    return current;
                }
                current = current.next;
            }
            return null; // Not found
        }

        // Method to traverse and display all tasks
        public void traverseTasks() {
            Task current = head;
            System.out.println("Task List:");
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }

        // Method to delete a task by ID
        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.getTaskId() == taskId) {
                head = head.next;
                System.out.println("Deleted task with ID: " + taskId);
                return;
            }

            Task current = head;
            while (current.next != null && current.next.getTaskId() != taskId) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                System.out.println("Deleted task with ID: " + taskId);
            } else {
                System.out.println("Task not found.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Adding tasks
        tms.addTask(new Task(1, "Task 1", "Pending"));
        tms.addTask(new Task(2, "Task 2", "In Progress"));
        tms.addTask(new Task(3, "Task 3", "Completed"));

        // Traversing tasks
        tms.traverseTasks();

        // Searching for a task
        Task task = tms.searchTask(2);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Deleting a task
        tms.deleteTask(1);

        // Traversing tasks again
        tms.traverseTasks();
    }
}

