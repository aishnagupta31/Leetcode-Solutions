class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        int n = people.length;
        
        // Sort: taller first, if height same then smaller k first
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        // Initialize ans with [-1, -1] for all positions
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = -1;
            ans[i][1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            int count = people[i][1];
            
            for (int j = 0; j < n; j++) {
                if (ans[j][0] == -1 && count == 0) {
                    ans[j][0] = people[i][0];
                    ans[j][1] = people[i][1];
                    break;
                } 
                else if (ans[j][0] == -1 || ans[j][0] >= people[i][0]) {
                    count--;
                }
            }
        }
        
        return ans;
    }
}