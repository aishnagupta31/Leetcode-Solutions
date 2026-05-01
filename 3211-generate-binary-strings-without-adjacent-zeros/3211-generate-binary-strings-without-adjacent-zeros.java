class Solution {

    public void generate(int ind, int prev, List<String> res, int n, StringBuilder sb) {
        if (ind == n) {
            res.add(sb.toString());
            return;
        }

        if (prev == -1 || sb.charAt(prev) == '1') {

            sb.append('0');
            generate(ind + 1, ind, res, n, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('1');
            generate(ind + 1, ind, res, n, sb);
            sb.deleteCharAt(sb.length() - 1);

        } else {
            sb.append('1');
            generate(ind + 1, ind, res, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        generate(0, -1, res, n, new StringBuilder());
        return res;
    }
}