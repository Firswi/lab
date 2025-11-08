package lab1;

public class NumberChecker {

    public static void printMatchingNumbers(int min, int max) {
        for (int n = min; n <= max; n++) {
            if (isPalindrome(n) && isPrime(sumDigits(n)) && hasRepeatingDigits(n)) {
                System.out.println(n);
            }
        }
    }

    private static boolean isPalindrome(int n) {
        String s = Integer.toString(n);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private  static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;

        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private static boolean hasRepeatingDigits(int n) {
        boolean[] seen = new boolean[10];
        while (n > 0) {
            int d = n % 10;
            if (seen[d]) return true;
            seen[d] = true;
            n /= 10;
        }
        return false;
    }
}

