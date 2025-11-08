package lab4;

public class BankAccount {
        protected String owner;
        protected double balance;

        public BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Депозит " + amount + ". Новый баланс: " + balance);
            } else {
                System.out.println("Доступные средства.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Снято " + amount + ". Новый баланс: " + balance);
            } else {
                System.out.println("Недостаточно средств или неверная сумма.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public String getOwner() {
            return owner;
        }

}
