package SavingsAccountClasses;

public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;


    public SavingsAccount(double currentBalance) {
        savingsBalance = currentBalance;
        annualInterestRate = 0;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest;
        System.out.println("Current Balance: " + (Math.round(savingsBalance * 100.00) / 100.00));
        monthlyInterest = savingsBalance * (annualInterestRate / 12);
        savingsBalance += monthlyInterest;
        System.out.println("New Balance: " + (Math.round(savingsBalance * 100.00) / 100.00));
        System.out.println();
    }

    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }


}
