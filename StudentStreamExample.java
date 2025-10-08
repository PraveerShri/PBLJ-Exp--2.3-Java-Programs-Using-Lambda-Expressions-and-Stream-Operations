import java.util.*;
import java.util.stream.*;

class Student {
    int id;
    String name;
    double marks;

    // Constructor
    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display method
    void display() {
        System.out.println(id + "  " + name + "  " + marks);
    }
}

public class StudentStreamExample {
    public static void main(String[] args) {

        // Creating list of students
        List<Student> students = Arrays.asList(
                new Student(1, "Praveer", 82.5),
                new Student(2, "Rohit", 65.0),
                new Student(3, "Anjali", 91.2),
                new Student(4, "Kiran", 76.8),
                new Student(5, "Ravi", 59.3)
        );

        System.out.println("All Students:");
        students.forEach(s -> s.display());

        // Filter students with marks >= 70
        System.out.println("\nStudents with Marks >= 70:");
        students.stream()
                .filter(s -> s.marks >= 70)
                .forEach(s -> s.display());

        // Sort students by marks in descending order
        System.out.println("\nStudents Sorted by Marks (Descending):");
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .forEach(s -> s.display());

        // Sort students by name in ascending order
        System.out.println("\nStudents Sorted by Name (Ascending):");
        students.stream()
                .sorted(Comparator.comparing(s -> s.name))
                .forEach(s -> s.display());
    }
}
