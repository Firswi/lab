package lab4;

public class lab4Main {
        public static void main(String[] args) {
            BankAccount basicAccount = new BankAccount("Alice", 1000);
            basicAccount.deposit(500);
            basicAccount.withdraw(200);

            SavingsAccount savings = new SavingsAccount("Bob", 2000, 5);
            savings.addInterest();
            savings.withdraw(1000);

            DepositAccount deposit = new DepositAccount("Charlie", 3000, 12);
            deposit.withdraw(500);
            deposit.endTerm();
            deposit.withdraw(500);

            CreditAccount credit = new CreditAccount("Dave", 1000, 10);
            credit.withdraw(500);
            credit.addInterest();
        }

}
