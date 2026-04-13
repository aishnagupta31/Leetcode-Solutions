class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n];
        int sum = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += matrix[i][j];
            }
            res[i] = sum;
            sum = 0;
        }

        return res;
    }
}