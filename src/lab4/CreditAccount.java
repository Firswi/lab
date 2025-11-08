package lab4;

    public class CreditAccount extends BankAccount {
        private double creditLimit;
        private double interestRate;

        public CreditAccount(String owner, double creditLimit, double interestRate) {
            super(owner, 0);
            this.creditLimit = creditLimit;
            this.interestRate = interestRate;
        }

        @Override
        public void withdraw(double amount) {
            if (amount <= balance + creditLimit) {
                balance -= amount;
                System.out.println("Снято " + amount + ". Новый баланс: " + balance);
            } else {
                System.out.println("Кредитный лимит увеличен.");
            }
        }

        public void addInterest() {
            if (balance < 0) {
                double interest = -balance * interestRate / 100;
                balance -= interest;
                System.out.println("Добавлены проценты по долгу: " + interest + ". Новый баланс: " + balance);
            }
        }
    }

