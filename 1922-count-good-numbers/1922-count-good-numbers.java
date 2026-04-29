class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenWays = power(5, evenCount);
        long oddWays = power(4, oddCount);

        return (int)((evenWays * oddWays) % MOD);
    }

    // Fast exponentiation
    public long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) { // if odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp = exp >> 1; // divide by 2
        }

        return result;
    }
}