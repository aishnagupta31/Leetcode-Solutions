class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            // If middle element is greater than the end element, the minimum is on the right half
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // Otherwise, the minimum is on the left half or could be at mid
            else {
                end = mid;
            }
        }
        
        // At the end, start == end and points to the minimum element
        return nums[start];
    }
}
