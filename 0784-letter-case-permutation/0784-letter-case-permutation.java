class Solution {
    public void solve(int ind, String s, StringBuilder sb, List<String> res, int n) {
        // Base case
        if (ind == n) {
            res.add(sb.toString());
            return;
        }

        char ch = s.charAt(ind);

        // If character is digit, only one choice
        if (Character.isDigit(ch)) {
            sb.append(ch);
            solve(ind + 1, s, sb, res, n);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        } 
        else {
            // Lowercase choice
            sb.append(Character.toLowerCase(ch));
            solve(ind + 1, s, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);

            // Uppercase choice
            sb.append(Character.toUpperCase(ch));
            solve(ind + 1, s, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        solve(0, s, new StringBuilder(), res, n);
        return res;
    }
}