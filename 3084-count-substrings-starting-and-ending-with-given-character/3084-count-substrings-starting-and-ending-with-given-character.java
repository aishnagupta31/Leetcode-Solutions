class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        for(char ch: s.toCharArray()){
            if(ch == c){
                count++;
            }
        }
        return count * (count + 1) / 2; // n*(n+1)/2 = sum of first n natural nos.
    }
}