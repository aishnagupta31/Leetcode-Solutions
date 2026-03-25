class Solution {
    public boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        int[] res = {-1, -1};

        int prevPrime = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;

                    if (diff < minDiff) {
                        minDiff = diff;
                        res[0] = prevPrime;
                        res[1] = i;
                    }
                }
                prevPrime = i;
            }
        }

        return res;
    }
}