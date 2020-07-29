public class Algorithm{

 //matrix power
 public static long[][] matrix_pow(long[][] A, int exp) {
        if (exp == 1) {
            return A;
        }
        if (exp % 2 == 1) {
            long[][] A_clone = {{A[0][0], A[0][1]}, {A[1][0], A[1][1]}};
            A = matrix_pow(A, exp - 1);
            return matrix_mul(A, A_clone);
        }

        A = matrix_pow(A, exp / 2);
        return matrix_mul(A, A);
    }
    //matrix mulitplication
     public static long[][] matrix_mul(long[][] a, long[][] b) {
        return new long[][] {
                {(a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MODULO, (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MODULO},
                {(a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MODULO, (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MODULO}
        };
    }
}
