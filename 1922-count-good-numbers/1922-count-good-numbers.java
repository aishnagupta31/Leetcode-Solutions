class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        return (int)((evenWays * oddWays) % MOD);
    }

    public long power(long base, long exp) {
        // Base case
        if (exp == 0) return 1;

        long half = power(base, exp / 2);

        long result = (half * half) % MOD;

        // If exponent is odd
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }
}