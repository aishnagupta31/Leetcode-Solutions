class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        // Correct initialization
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Build arrays
        for (int i = 2; i < n; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Merge result
        int[] res = new int[n];
        int idx = 0;

        for (int x : arr1) {
            res[idx++] = x;
        }

        for (int x : arr2) {
            res[idx++] = x;
        }

        return res;
    }
}