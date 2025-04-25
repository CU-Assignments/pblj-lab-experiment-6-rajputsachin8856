import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Display method
    public void display() {
        System.out.println(name + " (Marks: " + marks + "/100)");
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Marks out of 100: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            students.add(new Student(name, marks));
        }

        // Filtering students who scored above 75% and sorting by marks (descending order)
        List<Student> filteredSortedStudents = students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()
                        .thenComparing(Student::getName)) // Sort by name if marks are the same
                .collect(Collectors.toList());

        // Displaying results
        if (filteredSortedStudents.isEmpty()) {
            System.out.println("No students scored above 75%.");
        } else {
            System.out.println("\nStudents who scored above 75%, sorted by marks:");
            filteredSortedStudents.forEach(Student::display);
        }

        scanner.close();
    }
}
