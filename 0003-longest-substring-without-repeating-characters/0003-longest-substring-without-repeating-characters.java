class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);

                while(map.get(ch) > 1){
                    char ch2 = s.charAt(left);
                    map.put(ch2, map.get(ch2) - 1);

                    if(map.get(ch2) == 0){
                        map.remove(map.get(ch2));
                    }

                    left++;
                }
            }

            map.put(ch, 1);

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}