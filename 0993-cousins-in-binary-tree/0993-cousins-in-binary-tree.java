/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;
            TreeNode parentX = null, parentY = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // check left child
                if (curr.left != null) {
                    if (curr.left.val == x) {
                        foundX = true;
                        parentX = curr;
                    } else if (curr.left.val == y) {
                        foundY = true;
                        parentY = curr;
                    }
                    queue.offer(curr.left);
                }

                // check right child
                if (curr.right != null) {
                    if (curr.right.val == x) {
                        foundX = true;
                        parentX = curr;
                    } else if (curr.right.val == y) {
                        foundY = true;
                        parentY = curr;
                    }
                    queue.offer(curr.right);
                }
            }

            // After scanning one level
            if (foundX && foundY) {
                // same level, now check parents
                return parentX != parentY;
            }
            if (foundX || foundY) {
                // only one found at this level
                return false;
            }
        }

        return false;
    }
}
// Yeh sabse simple aur clean approach hai 👇

// 💡 Intuition (Hinglish)

// Hum level by level traversal (BFS) karenge:

// Har level mein check karenge kya x aur y milte hain.

// Agar dono ek hi level pe milte hain, but unke parent alag hain, toh true.

// Agar same parent nikle, ya ek hi mil gaya, toh false.

// 🧠 Step-by-Step Explanation (Hinglish)

// Queue use karke tree ko level-by-level traverse karte hain.

// Har level pe:

// Dekhte hain kya x ya y kisi node ke child hain.

// Agar haan, toh unka parent store kar lete hain.

// Jab ek level complete ho jaata hai:

// Agar dono mil gaye → check karo kya parents alag hain → true.

// Agar sirf ek hi mila → wo alag level pe hoga → false.

// Nice — great question, Aishna! 🙌 Chalo step-by-step aur bahut detail mein samjhte hain ki jo BFS solution maine pehle diya tha usmein depth kaise handle hota hai, aur DFS version mein depth ko kaise explicitly track karte hain. Hinglish mein — simple aur clear. 💫

// 1) BFS (Level-order) — depth kaise handle hota hai (intuition + detail)
// Key idea (one-line)

// BFS implicitly depth ko handle karta hai by processing the tree level by level. Ek while-iteration = ek depth level.

// Mechanism (what the code does)

// Hum Queue<TreeNode> use karte hain.

// Har while loop start pe size = queue.size() liya jata hai — yeh size exactly batata hai current depth (level) mein kitne nodes hain.

// Fir for (i=0; i<size; i++) loop chalake wo saare nodes process karte hain jo us current depth pe hain.

// Jab hum curr node ke left ya right child ko check karte hain, toh woh child next depth (currentDepth + 1) pe hota hai.

// Isliye:

// Agar hum curr.left.val == x find karte hain, toh x ka depth = currentDepth + 1.

// Agar hum root ko start depth 0 maan ke chal rahe hain, toh har while ke baad agar hum chaahein toh depth++ kar sakte hain (explicit count).