class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) return false;

        // Step 1: Frequency map
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Process smallest element first
        while (!map.isEmpty()) {
            int first = map.firstKey(); // smallest element

            // Try to form a group
            for (int i = 0; i < groupSize; i++) {
                int curr = first + i;

                if (!map.containsKey(curr)) {
                    return false;
                }

                map.put(curr, map.get(curr) - 1);

                if (map.get(curr) == 0) {
                    map.remove(curr);
                }
            }
        }

        return true;
    }
}