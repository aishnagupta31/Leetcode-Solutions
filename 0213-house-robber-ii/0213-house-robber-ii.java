class Solution {
    public int maxNonAdjacentSum(int[] nums){
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0; //neg index for now after each iteration we ill update it
        for(int i=1; i<n; i++){
            int take = nums[i];
            if(i > 1) take += prev2;

            int notTake = 0 + prev1;

            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i=0; i<n; i++){
            if(i != 0) temp1[i] = nums[i]; //temp1 array contains rest of the array except first element
            if(i != n-1) temp2[i] = nums[i]; //temp2 array contains rest of the array except last element
        }

        return Math.max(maxNonAdjacentSum(temp1), maxNonAdjacentSum(temp2));
    }
}
