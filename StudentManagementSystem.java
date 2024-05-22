//Student management system

import java.util.*;


// Define the Student class
class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String grade;
    private String contactInfo;

    public Student(int id, String name, int age, String gender, String grade, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.contactInfo = contactInfo;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getGrade() { return grade; }
    public String getContactInfo() { return contactInfo; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Grade: " + grade + ", Contact Info: " + contactInfo;
    }
}

// Define the StudentManagementSystem class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String adminUsername = "admin";
    private static String adminPassword = "password";

    public static void main(String[] args) {
        if (adminLogin()) {
            menu();
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    private static boolean adminLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return username.equals(adminUsername) && password.equals(adminPassword);
    }

    private static void menu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("A. Add a new student");
            System.out.println("B. Remove a student by ID");
            System.out.println("C. Update student information");
            System.out.println("D. Display all students");
            System.out.println("E. Search for a student");
            System.out.println("F. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    addStudent();
                    break;
                case "B":
                    removeStudent();
                    break;
                case "C":
                    updateStudent();
                    break;
                case "D":
                    displayAllStudents();
                    break;
                case "E":
                    searchStudent();
                    break;
                case "F":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (getStudentById(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();

        students.add(new Student(id, name, age, gender, grade, contactInfo));
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter ID of the student to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            students.remove(student);
            System.out.println("Student removed successfully.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID of the student to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter new age (leave blank to keep current): ");
        String age = scanner.nextLine();
        if (!age.isEmpty()) {
            student.setAge(Integer.parseInt(age));
        }

        System.out.print("Enter new gender (leave blank to keep current): ");
        String gender = scanner.nextLine();
        if (!gender.isEmpty()) {
            student.setGender(gender);
        }

        System.out.print("Enter new grade (leave blank to keep current): ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) {
            student.setGrade(grade);
        }

        System.out.print("Enter new contact info (leave blank to keep current): ");
        String contactInfo = scanner.nextLine();
        if (!contactInfo.isEmpty()) {
            student.setContactInfo(contactInfo);
        }

        System.out.println("Student information updated successfully.");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter search criteria (ID, name, grade): ");
        String criteria = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Student student : students) {
            if (String.valueOf(student.getId()).equals(criteria) ||
                    student.getName().toLowerCase().contains(criteria) ||
                    student.getGrade().toLowerCase().contains(criteria)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with the given criteria.");
        }
    }

    private static Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
