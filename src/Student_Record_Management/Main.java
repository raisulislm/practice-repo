package src.Student_Record_Management;

import java.util.Scanner;

public class Main {

    public static Student findLowestCGPA(Student head) {
        Student lowest = head;
        Student current = head;

        while (current != null) {
            if (current.getCgpa() < lowest.getCgpa()) {
                lowest = current;
            }
            current = current.getNext();
        }

        return lowest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Student head = null;
        Student tail = null;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter info for student " + (i + 1));

            System.out.print("ID: ");
            long id = sc.nextLong();
            sc.nextLine();

            System.out.print("Full Name: ");
            String name = sc.nextLine();

            System.out.print("Blood Group: ");
            String bg = sc.nextLine();

            System.out.print("CGPA: ");
            float cgpa = sc.nextFloat();
            sc.nextLine();

            Student s = new Student(id, name, bg, cgpa);

            if (head == null) {
                head = s;
                tail = s;
            } else {
                tail.setNext(s);
                tail = s;
            }
        }

        System.out.print("Enter query string: ");
        String query = sc.nextLine();

        System.out.println("\nMatching Students:");
        Student current = head;
        while (current != null) {
            if (current.matches(query)) {
                current.print();
            }
            current = current.getNext();
        }

        Student lowest = findLowestCGPA(head);
        System.out.println("Student with Lowest CGPA:");
        lowest.print();
    }
}
