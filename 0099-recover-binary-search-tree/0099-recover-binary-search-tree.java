//O(1) solution - optimized
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        // swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}