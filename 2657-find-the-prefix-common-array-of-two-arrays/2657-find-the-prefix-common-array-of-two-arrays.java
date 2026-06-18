class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0; 
        for(int i=0; i<n; i++){
            if(arr.contains(A[i])){
                count++;
            }
            arr.add(A[i]);
            if(arr.contains(B[i])){
                count++;
            }
            arr.add(B[i]);
            res[i] = count;
        }

        return res;
    }
}