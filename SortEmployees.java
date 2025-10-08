import java.util.*;

// Employee class (no need to make it public)
class Employee {
    int id;
    String name;
    double salary;

    // Constructor
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Display method
    void display() {
        System.out.println(id + "  " + name + "  " + salary);
    }
}

// Main class (public class must match file name)
public class SortEmployees {
    public static void main(String[] args) {

        // Create list of employees
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Praveer", 55000));
        list.add(new Employee(102, "Rohit", 48000));
        list.add(new Employee(103, "Anjali", 65000));
        list.add(new Employee(104, "Kiran", 52000));

        System.out.println("Before Sorting:");
        list.forEach(e -> e.display());

        // Sort by Name (Ascending order)
        list.sort((e1, e2) -> e1.name.compareTo(e2.name));

        System.out.println("\nAfter Sorting by Name (Ascending):");
        list.forEach(e -> e.display());

        // Sort by Salary (Descending order)
        list.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        System.out.println("\nAfter Sorting by Salary (Descending):");
        list.forEach(e -> e.display());
    }
}
