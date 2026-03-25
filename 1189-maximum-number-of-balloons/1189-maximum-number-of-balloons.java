class Solution {
    public int maxNumberOfBalloons(String s) {
        int Freq[]= new int[26];
        for(char ch : s.toCharArray()){
            Freq[ch -'a']++;
        }
        return Math.min(
            Math.min(Math.min(Freq['b'-'a'], Freq['a'-'a']), Math.min(Freq['l'-'a']/2, Freq['o'-'a']/2)), Freq['n'-'a']);

    }
}