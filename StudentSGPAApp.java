import java.util.Scanner;

class Student {
    // Member variables
    private String usn;
    private String name;
    private int[] credits;  // Array to store credits for each subject
    private int[] marks;    // Array to store marks (out of 100) for each subject
    private int numSubjects; // To store the number of subjects

    // Constructor to initialize the number of subjects
    public Student(int numSubjects) {
        this.numSubjects = numSubjects;
        this.credits = new int[numSubjects];
        this.marks = new int[numSubjects];
    }

    /**
     * Helper method to convert marks (out of 100) to grade points.
     * This is based on a typical grading scale.
     */
    private int getGradePoint(int mark) {
        if (mark >= 90) return 10; // S Grade
        else if (mark >= 80) return 9; // A Grade
        else if (mark >= 70) return 8; // B Grade
        else if (mark >= 60) return 7; // C Grade
        else if (mark >= 50) return 6; // D Grade
        else if (mark >= 40) return 4; // E Grade (Passing grade)
        else return 0; // F Grade (Failing grade)
    }

    // Method to accept student details, credits, and marks
    public void acceptDetails(Scanner scanner) {
        System.out.print("Enter USN: ");
        this.usn = scanner.nextLine();
        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();

        System.out.println("\nEnter Credits and Marks for " + this.numSubjects + " subjects:");
        for (int i = 0; i < this.numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + " - Enter Credits: ");
            // Input validation for credits (simplified)
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer for credits.");
                scanner.next(); // Consume the invalid input
                System.out.print("Subject " + (i + 1) + " - Enter Credits: ");
            }
            this.credits[i] = scanner.nextInt();

            System.out.print("Subject " + (i + 1) + " - Enter Marks (out of 100): ");
            // Input validation for marks (simplified)
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer for marks.");
                scanner.next(); // Consume the invalid input
                System.out.print("Subject " + (i + 1) + " - Enter Marks (out of 100): ");
            }
            this.marks[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume the newline left after reading integers
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN: " + this.usn);
        System.out.println("Name: " + this.name);
        System.out.println("Number of Subjects: " + this.numSubjects);
        System.out.println("\nSubject-wise Performance:");

        System.out.printf("%-10s | %-8s | %-10s | %-12s%n", "Subject #", "Credits", "Marks", "Grade Point");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < this.numSubjects; i++) {
            System.out.printf("%-10d | %-8d | %-10d | %-12d%n",
                    (i + 1), this.credits[i], this.marks[i], getGradePoint(this.marks[i]));
        }
    }

    // Method to calculate and display SGPA
    public double calculateSGPA() {
        double totalCreditPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < this.numSubjects; i++) {
            int gradePoint = getGradePoint(this.marks[i]);
            int credit = this.credits[i];

            // SGPA formula component: Credit * Grade Point
            totalCreditPoints += (double) credit * gradePoint;
            totalCredits += credit;
        }

        // SGPA = Sum of (Credit * Grade Point) / Sum of Credits
        double sgpa = (totalCredits > 0) ? (totalCreditPoints / totalCredits) : 0.0;

        return sgpa;
    }
}

// Main class to run the program
public class StudentSGPAApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get the number of subjects
        System.out.print("Enter the number of subjects for the student: ");
        int numSub;
        while (!scanner.hasNextInt() || (numSub = scanner.nextInt()) <= 0) {
            System.out.println("Invalid input. Please enter a positive integer for the number of subjects.");
            scanner.next(); // Consume the invalid input
            System.out.print("Enter the number of subjects for the student: ");
        }
        scanner.nextLine(); // Consume the newline

        // 2. Create Student object
        Student student = new Student(numSub);

        // 3. Accept details
        student.acceptDetails(scanner);

        // 4. Display details
        student.displayDetails();

        // 5. Calculate and display SGPA
        double sgpa = student.calculateSGPA();
        System.out.println("\n----------------------------------------------");
        System.out.printf("SGPA (Semester Grade Point Average): %.2f%n", sgpa);
        System.out.println("----------------------------------------------");

        scanner.close();
    }
}