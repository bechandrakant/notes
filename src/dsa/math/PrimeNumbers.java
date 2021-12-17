package dsa.math;

public class PrimeNumbers {
    public static void main(String[] args) {
        int N = 20;
        boolean[] b = primes(N);
        int[] spf = smallestPrimeFactors(N);
        int[] cod = countOfDivisorsV2(N);

        for (int i = 1; i < b.length; i++) {
            System.out.print(i + " " + cod[i] + "    ");
        }
    }

    /**
     * Calculates count of divisors of Numbers 1 -> N
     * Using Sieve method TC: O(N log(N))
     * @param N an integer
     * @return an array with count of divisors
     */
    static int[] countOfDivisors(int N) {
        int[] divisors = new int[N + 1];
        for (int i = 1; i <= N; i++) divisors[i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                divisors[j] += 1;
            }
        }

        return divisors;
    }

    /**
     * Calculates count of divisors of Numbers 1 -> N
     * Using Prime Factorization method TC: O(N log (log(N)))
     * @param N an integer
     * @return an array with count of divisors
     */
     static int[] countOfDivisorsV2(int N) {
        int[] divisors = new int[N + 1];
        int[] spf = smallestPrimeFactors(N);

        for (int i = 1; i <= N; i++) divisors[i] = 1;

        for (int i = 1; i <= N; i++) {
            int n = i;
            int X = spf[i];
            int ans = 1;
            while(n > 1) {
                int count = 1;
                while(n % X == 0) {
                    n /= X;
                    count++;
                }
                ans *= count;
                X++;
            }
            divisors[i] = ans;
        }

        return divisors;
    }

    /**
     * Calculates the smallest prime factors of 2 -> N
     * Using Seive method TC: O(N log (log(N)))
     * @param N an integer
     * @return an array with the smallest prime factor
     */
    static int[] smallestPrimeFactors(int N) {
        int[] spf = new int[N + 1];
        for (int i = 1; i <= N; i++) spf[i] = i;

        int root = (int) Math.ceil(Math.sqrt(N));
        for (int i = 2; i <= root; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    spf[j] = Math.min(spf[j], i);
                }
            }
        }
        return spf;
    }

    /**
     * Checks if a Number is Prime 1 -> N
     * Using Seive method TC: O(N log (log(N)))
     * @param N an integer
     * @return a boolean array
     */
    static boolean[] primes(int N) {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        int root = (int) Math.ceil(Math.sqrt(N));
        for (int i = 2; i <= root; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
