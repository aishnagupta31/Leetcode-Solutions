class Solution {
    public void generate(int ind, List<Integer> arr, List<List<Integer>> res, int n, int[] nums){

        for(int j=ind; j<n; j++){
            arr.add(nums[j]);
            res.add(new ArrayList<>(arr));
            generate(j + 1, arr, res, n, nums);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());
        generate(0, new ArrayList<>(), res, n, nums);
        return res;
    }
}