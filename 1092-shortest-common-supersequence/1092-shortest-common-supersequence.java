class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        // LCS table build
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Backtrack to build SCS
        int i = n, j = m;
        StringBuilder res = new StringBuilder();

        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                res.append(str1.charAt(i-1));
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                res.append(str1.charAt(i-1));
                i--;
            }
            else{
                res.append(str2.charAt(j-1));
                j--;
            }
        }

        // remaining characters
        while(i > 0){
            res.append(str1.charAt(i-1));
            i--;
        }

        while(j > 0){
            res.append(str2.charAt(j-1));
            j--;
        }

        return res.reverse().toString();
    }
}


//  Jab characters same:

// use ek baar add karo

//  Jab different:

// jis side ka LCS bada hai → usko follow karo