import java.util.Scanner;

public class Main {
    static long mod = 10000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long[] gcd = extendedGCDIterative(a, b);
            System.out.println(gcd[0] + ":" + gcd[1] + ":" + gcd[2]);
        }
    }

    //recursive
    public static long[] extendedGCD(long a, long b) {
        if (b == 0) {
            return new long[] {a, 1, 0};
        }

        long[] gcd = extendedGCD(b, a % b);
        long x = gcd[2];
        long y = gcd[1] - (gcd[2] * (a / b));
        long GCD = gcd[0];
        return new long[] {GCD, x, y};
    }

    //iterative
    public static long[] extendedGCDIterative(long a, long b) {
        long x = 0, y = 1, lastx = 1, lasty = 0, temp;
        while (b != 0) {
            long q = a / b;
            long r = a % b;

            a = b;
            b = r;

            temp = x;
            x = lastx - q * x;
            lastx = temp;

            temp = y;
            y = lasty - q * y;
            lasty = temp;
        }
        System.out.println("Roots  x : " + lastx + " y :" + lasty);

        return new long[] {a, x, y};
    }

    public static long lcm(long a, long b, long gcd) {
        return (a / gcd) * b;
    }
}
