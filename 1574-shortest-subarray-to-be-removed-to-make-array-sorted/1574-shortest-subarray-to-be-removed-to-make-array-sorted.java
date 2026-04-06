class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // right side se sorted part ka starting index nikaalo
        int j = n - 1;
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        // shuru me maan lo left side ka part hata denge
        int result = j;

        int i = 0;

        // left side se sorted elements check karte jao
        while (i < j && (i == 0 || arr[i] >= arr[i - 1])) {

            // j ko aage badhao jab tak dono side connect na ho jaaye
            while (j < n && arr[i] > arr[j]) {
                j++;
            }

            // beech ka part remove hoga
            result = Math.min(result, j - i - 1);

            // next element try karo
            i++;
        }

        return result;
    }
}