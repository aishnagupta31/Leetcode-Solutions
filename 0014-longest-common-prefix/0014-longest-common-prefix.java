class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;

            while (j < pre.length() && j < strs[i].length()) {
                if (pre.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }

            pre = pre.substring(0, j);

            if (pre.equals("")) {
                return "";
            }
        }

        return pre;
    }
}