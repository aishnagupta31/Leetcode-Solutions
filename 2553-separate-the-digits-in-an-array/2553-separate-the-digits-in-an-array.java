class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    public void separate(int num) {
        ArrayList<Integer> temp = new ArrayList<>();

        while (num > 0) {
            temp.add(num % 10);
            num = num / 10;
        }

        Collections.reverse(temp);

        ans.addAll(temp);
    }

    public int[] separateDigits(int[] nums) {
        for (int num : nums) {
            separate(num);
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}