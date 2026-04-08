class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return Math.min(odd, even);
    }
}

























// https://chatgpt.com/c/69d63630-a078-8323-9d5c-f5f22449b77b