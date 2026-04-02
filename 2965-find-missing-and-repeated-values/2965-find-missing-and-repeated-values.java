class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] res = new int[2];
        int n = grid.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr.contains(grid[i][j])){
                    res[0] = grid[i][j];
                }
                else{
                    arr.add(grid[i][j]);
                }
            }
        }
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i);
        }

        int total = 0;
        for(int i=0; i<=n*n; i++){
            total += i;
        }

        res[1] = total - sum;

        return res;
    }
}