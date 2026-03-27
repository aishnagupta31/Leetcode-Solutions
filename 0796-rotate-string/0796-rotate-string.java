class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        return (s + s).contains(goal);
    }
}