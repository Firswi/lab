package lab2;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (!checkLength(password)) return false;
        if (!checkRequiredSets(password)) return false;
        if (!checkNoSpaces(password)) return false;
        if (!checkNoMoreThanTwoIdentical(password)) return false;
        if (!checkNoMoreThanThreeSameCategory(password)) return false;

        return true;
    }

    private static boolean checkLength(String password) {
        return password != null && password.length() >= 8 && password.length() <= 20;
    }

    private static boolean checkRequiredSets(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;  // если не буква и не цифра — считаем спецсимволом
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    private static boolean checkNoSpaces(String password) {
        return !password.contains(" ");
    }

    private static boolean checkNoMoreThanTwoIdentical(String password) {
        int streak = 1;

        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                streak++;
                if (streak > 2) return false;
            } else {
                streak = 1;
            }
        }
        return true;
    }

    private static boolean checkNoMoreThanThreeSameCategory(String password) {
        int lastCat = -1;
        int streak = 0;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            int cat = getCharCategorySimple(ch);

            if (cat == lastCat) {
                streak++;
                if (streak > 3) return false;
            } else {
                lastCat = cat;
                streak = 1;
            }
        }
        return true;
    }

    private static int getCharCategorySimple(char ch) {
        if (Character.isUpperCase(ch)) return 0;
        if (Character.isLowerCase(ch)) return 1;
        if (Character.isDigit(ch)) return 2;
        return 3;
    }
}

