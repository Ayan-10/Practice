import java.util.Scanner;

public class GCD {

    // Euclidean algorithm (recursive)
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(Math.abs(a), Math.abs(b)));

        scanner.close();
    }
}
