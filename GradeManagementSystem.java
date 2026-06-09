import java.util.ArrayList;
import java.util.Scanner;

public class GradeManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1: addStudent();break;
                case 2: displayAllStudents(); 
break;
                case 3: searchStudent();break;
                case 4: calculateAverage(); break;
                case 5: System.out.println("Exiting... Thank you!"); 
break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while(choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public static void displayAllStudents() {
        if(students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }
        for(Student s : students) {
            s.displayStudent();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        for(Student s : students) {
            if(s.getStudentId() == id) {
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }

    public static void calculateAverage() {
        if(students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }
        double total = 0;
        for(Student s : students) {
            total += s.getMarks();
        }
        double avg = total / students.size();
        System.out.printf("Average Marks:"+avg);
    }
}