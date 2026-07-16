class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;

        for (String row : bank) {
            int count = 0;

            for (char ch : row.toCharArray()) {
                if (ch == '1') {
                    count++;
                }
            }

            if (count == 0) {
                continue;
            }

            ans += prev * count;
            prev = count;
        }

        return ans;
    }
}