class Solution {
    public boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        HashSet<Long> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long num = Long.parseLong(s.substring(i, j + 1));
                if (isPrime(num)) {
                    set.add(num);
                }
            }
        }

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(set);

        int k = 3;
        long sum = 0;

        while (k > 0 && !pq.isEmpty()) {
            sum += pq.poll();
            k--;
        }

        return sum;
    }
}