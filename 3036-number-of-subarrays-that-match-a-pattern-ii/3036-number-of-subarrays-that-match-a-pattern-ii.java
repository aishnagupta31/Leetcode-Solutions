class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        // Step 1: Build diff array
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) diff[i] = 1;
            else if (nums[i + 1] == nums[i]) diff[i] = 0;
            else diff[i] = -1;
        }

        // Step 2: Build LPS (Longest Prefix Suffix) for KMP
        int[] lps = buildLPS(pattern);

        // Step 3: KMP Search
        int i = 0, j = 0, count = 0;

        while (i < diff.length) {
            if (diff[i] == pattern[j]) {
                i++;
                j++;
            }

            if (j == m) {
                count++;
                j = lps[j - 1]; // continue searching
            } else if (i < diff.length && diff[i] != pattern[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    private int[] buildLPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}