class Solution {

    public int countDigits(int num) {
        if (num == 0) return 1;

        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public int[] separateDigits(int[] nums) {

        int size = 0;
        for (int num : nums) {
            size += countDigits(num);
        }

        int[] res = new int[size];

        int idx = 0;

        for (int num : nums) {

            int digits = countDigits(num);
            int[] temp = new int[digits];

            for (int i = digits - 1; i >= 0; i--) {
                temp[i] = num % 10;
                num /= 10;
            }

            for (int d : temp) {
                res[idx++] = d;
            }
        }

        return res;
    }
}