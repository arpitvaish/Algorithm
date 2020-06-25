import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while (t-- > 0) {
            System.out.println(modex(sc.nextLong(), sc.nextLong(), 10));
        }

    }

   
    public static long ex(long x, long y) {
        long result = 1;
        if (y == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        //x = x % n;
        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x);
            }

            x = (x * x);
            y >>= 1;
        }

        return result;
    }

    public static long modex(long x, long y, long k) {
        long result = 1;
        if (y == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }

        //x = x % n;
        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x) % k;
            }

            x = (x * x) % k;
            y >>= 1;
        }

        return result;
    }
}
