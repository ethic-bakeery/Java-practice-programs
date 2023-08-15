import java.util.ArrayList;
import java.util.Scanner;

// Define a class to represent a student
class Student {
    String name;
    int id;
    double gpa;
}

public class StudentDatabase {
    // Define an ArrayList to store all the students
    static ArrayList<Student> students = new ArrayList<>();

    // Define a method to add a new student to the database
    static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Enter student name: ");
        student.name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        student.id = scanner.nextInt();
        System.out.print("Enter student GPA: ");
        student.gpa = scanner.nextDouble();
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Define a method to print all the students in the database
    static void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            System.out.println("Students in the database:");
            for (Student student : students) {
                System.out.println("Name: " + student.name + ", ID: " + student.id + ", GPA: " + student.gpa);
            }
        }
    }

    // Define a method to search for a student by ID
    static void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to search for: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Student found:");
                System.out.println("Name: " + student.name + ", ID: " + student.id + ", GPA: " + student.gpa);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Define a method to delete a student by ID
    static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Define the main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Print all students");
            System.out.println("3. Search for a student");
            System.out.println("4. Delete a student");
            System.out.println("5. Quit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    printStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
