import java.util.Scanner;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to check if it's an ugly number:");
        int num = scanner.nextInt();
        boolean isUgly = isUglyNumber(num);
        System.out.println(num + " is " + (isUgly ? "an ugly number." : "not an ugly number."));
        scanner.close();
    }

    public static boolean isUglyNumber(int num) {
        if (num <= 0) return false; // Ugly numbers are positive
        if (num == 1) return true; // 1 is treated as an ugly number

        // Divide num by 2, 3, and 5 as long as it is divisible by them
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0) {
                num /= factor;
            }
        }

        return num == 1; // If num has been reduced to 1, it is an ugly number
    }
}
