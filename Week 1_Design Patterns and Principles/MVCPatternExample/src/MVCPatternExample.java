public class MVCPatternExample {

    // Model Class
    static class Student {
        private String id;
        private String name;
        private String grade;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // View Class
    static class StudentView {
        public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    // Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentId(String id) {
            model.setId(id);
        }

        public String getStudentId() {
            return model.getId();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Main method to demonstrate the MVC Pattern
    public static void main(String[] args) {
        // Create a Student object
        Student model = retrieveStudentFromDatabase();

        // Create a StudentView object
        StudentView view = new StudentView();

        // Create a StudentController object
        StudentController controller = new StudentController(model, view);

        // Display the initial details
        controller.updateView();

        // Update the student's details
        controller.setStudentName("Ayush Das");
        controller.setStudentGrade("A+");

        // Display the updated details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setId("1");
        student.setName("Priyanshu Mondal");
        student.setGrade("B");
        return student;
    }
}
