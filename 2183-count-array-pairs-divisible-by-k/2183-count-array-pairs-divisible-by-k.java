class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int num : nums) {
            int g = gcd(num, k);

            for (int prevGcd : map.keySet()) {
                if ((1L * g * prevGcd) % k == 0) {
                    count += map.get(prevGcd);
                }
            }

            map.put(g, map.getOrDefault(g, 0) + 1);
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}