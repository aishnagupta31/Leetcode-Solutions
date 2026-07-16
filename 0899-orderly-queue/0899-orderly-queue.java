import java.util.*;

class Solution {
    public String orderlyQueue(String s, int k) {
        
        // Case 1: Only rotations are allowed
        if (k == 1) {
            String ans = s;
            
            for (int i = 1; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                
                if (rotated.compareTo(ans) < 0) {
                    ans = rotated;
                }
            }
            
            return ans;
        }
        
        // Case 2: We can reorder characters freely
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        return new String(arr);
    }
}