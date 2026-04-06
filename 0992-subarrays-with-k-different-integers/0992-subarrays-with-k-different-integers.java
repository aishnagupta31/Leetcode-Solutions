class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);      
    }

    private int atMost(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;

        for(int right=0; right<n; right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0)+1);
            
            while(map.size() > k){
                int leftnum = nums[left];
                map.put(leftnum, map.get(leftnum)-1);

                if(map.get(leftnum) == 0){
                    map.remove(leftnum);
                }

                left++;
            }

            count += right - left + 1;
        } 

        return count; 
    }
}



// https://chatgpt.com/c/69d4177d-3414-8323-ba3a-47bc9060b84b