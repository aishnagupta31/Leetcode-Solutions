class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);

            if (i + 1 < n) {
                char ch2 = s.charAt(i + 1);

                if (map.get(ch1) < map.get(ch2)) {
                    sum += map.get(ch2) - map.get(ch1);
                    i++;
                } else {
                    sum += map.get(ch1);
                }
            } else {
                sum += map.get(ch1);
            }
        }

        return sum;
    }
}