class Solution {
    public int maxnum(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    public boolean isGood(int[] nums) {
        int max = maxnum(nums);

        if (nums.length != max + 1) {
            return false;
        }

        int[] freq = new int[max + 1];

        for (int num : nums) {
            if (num > max || num < 1) {
                return false;
            }
            freq[num]++;
        }

        for (int i = 1; i < max; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        return freq[max] == 2;
    }
}