class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean reverse = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                arr.add(current.val);

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (reverse) {
                Collections.reverse(arr);
            }

            res.add(arr);

            reverse = !reverse; // toggle for next level
        }

        return res;
    }
}