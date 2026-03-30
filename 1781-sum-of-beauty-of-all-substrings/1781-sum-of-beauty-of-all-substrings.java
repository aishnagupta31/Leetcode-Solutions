import java.util.*;

class Solution {
    
    public int calcMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i));
        }
        return min;
    }

    public int calcMax(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
        }
        return max;
    }

    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() > 1) {
                    ArrayList<Integer> arr = new ArrayList<>(map.values());
                    int min = calcMin(arr);
                    int max = calcMax(arr);

                    sum += (max - min);
                }
            }
        }

        return sum;
    }
}