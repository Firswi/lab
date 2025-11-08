package lab2;

public class lab2Main {
        public static void main(String[] args) {
            String password = "SpAsIbO11!";

            if (PasswordValidator.isValid(password)) {
                System.out.println("Пароль подходит");
            } else {
                System.out.println("Пароль не подходит");
            }
        }

}
