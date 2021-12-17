package dsa.recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(fibonacci(5));
        System.out.println(factorial(5));
        System.out.println(power(3, 5));
        System.out.println(powerV2(3, 5));
        System.out.println(gcd(3, 6));
    }

    /**
     * Calculates sum of first N natural numbers
     * @param N: an integer
     * @return sum
     * Time Complexity: O(N)
     */
    public static int sum(int N) {
        if (N == 0) {
            return N;
        }
        return N + sum(N - 1);
    }

    /**
     * Calculates factorial of first N natural numbers
     * @param N: an integer
     * @return factorial
     * Time Complexity: O(N)
     */
    public static int factorial(int N) {
        if (N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }

    /**
     * Calculates and returns Nth fibonacci number
     * @param N: an integer
     * @return fibonacci
     * Time Complexity: O(2^N)
     */
    public static int fibonacci(int N) {
        if (N <= 1) {
            return N;
        }
        return fibonacci(N - 1) + fibonacci(N - 2);
    }

    /**
     * Calculates and returns A power N
     * @param A: Base, an integer
     * @param N: Power, an integer
     * @return A raised to power N
     * Time Complexity: O(N)
     */
    public static int power(int A, int N) {
        if (N == 0) return 1;
        return A * power(A, N - 1);
    }

    /**
     * Calculates and returns A power N
     * @param A: Base, an integer
     * @param N: Power, an integer
     * @return A raised to power N
     * Time Complexity: O(log N)
     */
    public static int powerV2(int A, int N) {
        if (N == 0) return 1;
        int power = powerV2(A, N / 2);
        if ((N & 1) == 0) return power * power;
        else return A * power * power;
    }

    /**
     * Calculates and returns GCD of A and B
     * @param A: an integer
     * @param B: an integer
     * @return GCD (A, B)
     * Time Complexity: O(log(min(A, B))
     */
    public static int gcd(int A, int B) {
        if (A == 0) return B;
        if (B == 0) return A;
        return gcd(B % A, A);
    }
}
