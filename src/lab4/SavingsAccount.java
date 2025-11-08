package lab4;

    public class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(String owner, double initialBalance, double interestRate) {
            super(owner, initialBalance);
            this.interestRate = interestRate;
        }

        public void addInterest() {
            double interest = balance * interestRate / 100;
            balance += interest;
            System.out.println("Проценты начислены: " + interest + ". Новый баланс: " + balance);
        }
    }

