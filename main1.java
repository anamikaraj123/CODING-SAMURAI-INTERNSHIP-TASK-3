
    
import java.util.Scanner;

class GradeCalculator {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Grade Calculator");

        // Collecting grades
        double assignments = getMarks("Assignments");
        double quizzes = getMarks("Quizzes");
        double midtermExam = getMarks("Midterm Exam");
        double finalExam = getMarks("Final Exam");

        // Grading scale
        double[] gradeRangesNumber = { 90, 80, 70, 60, 0 };
        String[] letterGrades = { "A", "B", "C", "D", "F" };

        // Calculating overall grade
        double overallGrade = overall(assignments, quizzes, midtermExam, finalExam);
        String finalLetterGrade = gradeLetter(overallGrade, gradeRangesNumber, letterGrades);

        // Displaying result
        System.out.println("Your overall course grade is: " + overallGrade);
        System.out.println("Final Letter Grade: " + finalLetterGrade);
    }

    // Function to collect grades
    private static double getMarks(String examType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your grade for " + examType + "out of 100" + ": ");
        return scanner.nextDouble();
    }

    // Function to calculate overall grade
    private static double overall(double assignments, double quizzes, double midtermExam,
            double finalExam) {
        // Adjusted weights for components
        double overallGrade = (assignments * 0.2) + (quizzes * 0.2) + (midtermExam * 0.3) + (finalExam * 0.3);
        return overallGrade;
    }

    // Function to determine letter grade
    private static String gradeLetter(double overallGrade, double[] gradeRanges, String[] letterGrades) {
        for (int i = 0; i < gradeRanges.length; i++) {
            if (overallGrade >= gradeRanges[i]) {
                return letterGrades[i];
            }
        }
        return "Error";
    }
}


