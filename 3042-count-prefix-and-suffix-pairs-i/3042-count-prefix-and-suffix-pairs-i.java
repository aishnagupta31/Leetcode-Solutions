class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String s1, String s2) {
        // s1 must be smaller or equal
        if (s1.length() > s2.length()) return false;

        return s2.startsWith(s1) && s2.endsWith(s1);
    }
}