class Solution {
    public int findPeakElement(int[] nums) {       
        int n = nums.length;
        int start = 0;
        int end = n-1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2; // avoid overflow
            
            // Check if mid is a peak element
            boolean isPeak = (mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]);
            
            if (isPeak) {
                return mid;
            }
            
            // Move the search window
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                end = mid - 1; // Peak lies to the left
            } else {
                start = mid + 1; // Peak lies to the right
            }
        }
        
        return -1; // Should never reach here if the input array has at least one peak
    }
 
}
