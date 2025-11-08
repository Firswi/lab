package lab4;

    public class DepositAccount extends BankAccount {
        private int termInMonths;
        private boolean termEnded;

        public DepositAccount(String owner, double initialBalance, int termInMonths) {
            super(owner, initialBalance);
            this.termInMonths = termInMonths;
            this.termEnded = false;
        }

        public void endTerm() {
            termEnded = true;
            System.out.println("Срок депозита истёк. Вы можете вывести средства сейчас");
        }

        @Override
        public void withdraw(double amount) {
            if (!termEnded) {
                System.out.println("Невозможно снять до окончания срока депозита.");
            } else {
                super.withdraw(amount);
            }
        }
    }

