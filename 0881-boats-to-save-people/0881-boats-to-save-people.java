class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // sort array
        int n = people.length;
        int i = 0;         // lightest person
        int j = n - 1;     // heaviest person
        int boats = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++; // pair lightest with heaviest 
            }
            j--;     // heaviest always goes
            boats++; // one boat used
        }

        return boats;
    }
}


// ✅ Explanation:

// Sort the array to easily find lightest and heaviest people.

// Use two pointers: i for the lightest, j for the heaviest.

// If their sum ≤ limit, both can share a boat → move both pointers.

// If sum > limit, the heaviest goes alone → move j only.

// Increment boat count each time.

// This ensures minimum boats are used.