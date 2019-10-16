package SavingsAccountClasses;

public class Application {


    public static void main(String[] args) {
        int i;

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        for (i = 0; i < 12; i++) {
            System.out.printf("\n\n---Month %d (4 percent interest rate)---\n\n", i + 1);
            saver1.modifyInterestRate(0.04);
            System.out.print("Saver1 ");
            saver1.calculateMonthlyInterest();
            saver2.modifyInterestRate(0.04);
            System.out.print("Saver2 ");
            saver2.calculateMonthlyInterest();
        }

        System.out.println("---Month 13 (5 percent interest rate)---");
        saver1.modifyInterestRate(0.05);
        System.out.print("Saver1 ");
        saver1.calculateMonthlyInterest();
        saver2.modifyInterestRate(0.05);
        System.out.print("Saver2 ");
        saver2.calculateMonthlyInterest();
    }


}
