class Solution {
    public static int rev(int n){
        int ans = 0;
        while(n > 0){
            int digit = n % 10;
            ans = ans * 10 + digit;
            n = n / 10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min, i - map.get(nums[i]));
            }
            map.put(rev(nums[i]), i); 
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}