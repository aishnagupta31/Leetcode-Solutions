class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;

        for (int i = 0; i + m < n; i++) {
            boolean match = true;

            for (int k = 0; k < m; k++) {
                if (pattern[k] == 1 && nums[i + k + 1] <= nums[i + k]) {
                    match = false;
                    break;
                }
                if (pattern[k] == 0 && nums[i + k + 1] != nums[i + k]) {
                    match = false;
                    break;
                }
                if (pattern[k] == -1 && nums[i + k + 1] >= nums[i + k]) {
                    match = false;
                    break;
                }
            }

            if (match) count++;
        }

        return count;
    }
}