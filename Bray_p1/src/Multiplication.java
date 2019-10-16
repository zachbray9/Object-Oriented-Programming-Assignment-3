import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Double;


public class Multiplication {


    public static double getQuestionAndAnswer(SecureRandom rand, int difficulty, int problemType) {
        int num1 = 0, num2 = 0;
        switch (difficulty) {
            case 1:
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
                break;
            case 2:
                num1 = rand.nextInt(100);
                num2 = rand.nextInt(100);
                break;
            case 3:
                num1 = rand.nextInt(1000);
                num2 = rand.nextInt(1000);
                break;
            case 4:
                num1 = rand.nextInt(10000);
                num2 = rand.nextInt(10000);
                break;
        }

        switch (problemType) {
            case 1:
                System.out.printf("How much is %d + %d?\n", num1, num2);
                return num1 + num2;
            case 2:
                System.out.printf("How much is %d * %d?\n", num1, num2);
                return num1 * num2;
            case 3:
                System.out.printf("How much is %d - %d?\n", num1, num2);
                return num1 - num2;
            case 4:
                System.out.printf("How much is %d / %d? (Round your answer to 2 decimal places if necessary)\n", num1, num2);
                return (double) num1 / num2;
            case 5:
                switch (rand.nextInt(4)) {
                    case 0:
                        System.out.printf("How much is %d + %d?\n", num1, num2);
                        return num1 + num2;
                    case 1:
                        System.out.printf("How much is %d * %d?\n", num1, num2);
                        return num1 * num2;
                    case 2:
                        System.out.printf("How much is %d - %d?\n", num1, num2);
                        return num1 - num2;
                    case 3:
                        System.out.printf("How much is %d / %d? (Round your answer to 2 decimal places if necessary)\n", num1, num2);
                        return (double) num1 / num2;
                }
        }
        return 0;
    }


    public static void getComment(int num) {
        SecureRandom rand = new SecureRandom();
        if (num == 1) {
            switch (rand.nextInt(4)) {
                case 0:
                    System.out.print("Very good!\n\n");
                    break;
                case 1:
                    System.out.print("Excellent!\n\n");
                    break;
                case 2:
                    System.out.print("Nice work!\n\n");
                    break;
                case 3:
                    System.out.print("Keep up the good work!\n\n");
                    break;
            }
        } else {
            switch (rand.nextInt(4)) {
                case 0:
                    System.out.print("No. Please try again.\n\n");
                    break;
                case 1:
                    System.out.print("Wrong. Try once more.\n\n");
                    break;
                case 2:
                    System.out.print("Don't give up!\n\n");
                    break;
                case 3:
                    System.out.print("No. Keep trying.\n\n");
                    break;
            }
        }
    }

    public static int getDifficulty(Scanner scnr) {
        int choice;
        System.out.print("What difficulty would you like?\n");
        System.out.print("1 - Only single digit numbers\n");
        System.out.print("2 - Up to two digit numbers\n");
        System.out.print("3 - Up to three digit numbers\n");
        System.out.print("4 - Up to four digit numbers\n");
        choice = scnr.nextInt();
        return choice;
    }

    public static int getProblemType(Scanner scnr) {
        int choice;
        System.out.print("What type of problem would you like?\n");
        System.out.print("1 - Addition only\n");
        System.out.print("2 - Multiplication only\n");
        System.out.print("3 - Subtraction only\n");
        System.out.print("4 - Division only\n");
        System.out.print("5 - A mix of addition, multiplication, subtraction, and division\n");
        choice = scnr.nextInt();
        return choice;

    }


    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        final int NUM_QUESTIONS = 10;
        int i, difficulty, problemType;
        double numCorrect, numIncorrect, percentageCorrect;
        boolean run = true;
        char choice;

        double correctAnswer, userAnswer;

        while (run) {
            numCorrect = 0;
            numIncorrect = 0;

            difficulty = getDifficulty(scnr);
            problemType = getProblemType(scnr);

            for (i = 0; i < NUM_QUESTIONS; i++) {
                correctAnswer = Math.round(getQuestionAndAnswer(rand, difficulty, problemType) * 100.0) / 100.0;
                userAnswer = scnr.nextDouble();
                if (Double.compare(userAnswer, correctAnswer) == 0) {
                    getComment(1);
                    numCorrect += 1.0;
                } else {
                    getComment(0);
                    numIncorrect += 1;
                }
            }

            System.out.println("You got " + (int) numCorrect + " question(s) right.");
            System.out.println("You got " + (int) numIncorrect + " question(s) wrong.");

            percentageCorrect = numCorrect / NUM_QUESTIONS;
            if (percentageCorrect >= 0.75) {
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println("Please ask your teacher for extra help.");
            }

            System.out.print("\n");
            System.out.println("Would you like to reset? (y/n)");
            choice = scnr.next().charAt(0);
            if (choice == 'y') {
                run = true;
                System.out.print("\n\n\n");
            } else {
                run = false;
            }

        }


    }


}
