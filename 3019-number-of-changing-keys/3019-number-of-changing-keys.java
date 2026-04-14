class Solution {
    public int countKeyChanges(String s) {
        int n = s.length();
        String str = s.toLowerCase();
        int count = 0;
        for(int i=0; i<n-1; i++){
            if(str.charAt(i) != str.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}