class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);

            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;
    }
}

// Jab tak left part ka maximum element apni correct jagah tak nahi aa jata,
// tab tak cut nahi kar sakte.