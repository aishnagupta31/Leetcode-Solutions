class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // add space between words
            }
        }
        return reversed.toString();
    }
}