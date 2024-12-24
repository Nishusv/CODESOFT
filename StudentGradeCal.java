import java.util.Scanner;

public class StudentGradeCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input : No of sub
        System.out.print("Enter the number of subjects: ");
        int NoOfSub = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[NoOfSub];

        // Input : marks for sub
        for (int i = 0; i < NoOfSub; i++) {
            System.out.print("Enter marks obtained in subjects " + (i + 1) + " (out of 100):");
            marks[i] = scanner.nextInt();

            // validte input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input. Please enter marks:");
                marks[i] = scanner.nextInt();
            }
        }

        //calculate Total marks
        int totalMarks = calculateTotalMarks(marks);

        //calaulate Average Percentage
        double avgpercent = calculateTotalMarksPercent(totalMarks, NoOfSub);

        //Determine Grade
        char grade = determineGrade(avgpercent);

        //Display Results
        dispResults(totalMarks, avgpercent, grade);
        scanner.close();
    }

    private static int calculateTotalMarks(int[] marks){
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateTotalMarksPercent(int totalMarks, int NoOfSub){
        return (double) totalMarks / NoOfSub;
    }

    private static char determineGrade(double avgpercent){
        if (avgpercent >= 90){
            return 'A';
        } else if (avgpercent >= 80) {
            return 'B';
        } else if (avgpercent >= 70) {
            return 'C';
        } else if (avgpercent >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private static void dispResults(int totalMarks, double avgpercent, char grade){
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks:" + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", avgpercent);
        System.out.println("Grade: " + grade );
    }
}
