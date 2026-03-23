class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left=0;
        int right=people.length-1;
        int count=0;

        while(left<=right){
            if(people[left]+people[right] > limit){
                right--; // sum > limiit then heaviest go alone 
            }
            else{ // sum < limiit then both can share a boat
                left++;
                right--;
            }
            count++;
        }
        return count;
    }
}


// ✅ Explanation:

// Sort the array to easily find lightest and heaviest people.

// Use two pointers: i for the lightest, j for the heaviest.

// If their sum ≤ limit, both can share a boat → move both pointers.

// If sum > limit, the heaviest goes alone → move j only.

// Increment boat count each time.

// This ensures minimum boats are used.