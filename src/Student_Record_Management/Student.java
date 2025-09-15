package src.Student_Record_Management;

import java.util.Scanner;

public final class Student {
    private final long id;
    private final String fullName;
    private final String bloodGroup;
    private final float cgpa;

    private Student next; // for chaining students manually

    public Student(long id, String fullName, String bloodGroup, float cgpa, int loop) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.cgpa = cgpa;
        this.next = null;
    }

    // Encapsulation: no setters, only getters
    public float getCgpa() {
        return cgpa;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student nextStudent) {
        this.next = nextStudent;
    }

    public boolean matches(String query) {
        String[] parts = fullName.trim().split(" ");
        String lastName = parts.length > 1 ? parts[parts.length - 1] : "";
        return lastName.equalsIgnoreCase(query) || bloodGroup.equalsIgnoreCase(query);
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + fullName);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("CGPA: " + cgpa);
        System.out.println("----------------------");
    }
}
