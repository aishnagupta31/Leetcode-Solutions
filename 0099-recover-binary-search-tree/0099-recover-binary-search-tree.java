//O(n) solution - not optimized
class Solution {
    public void inorder(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public void recoverTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);

        Integer first = null, second = null;

        for(int i = 0; i < res.size() - 1; i++){
            if(res.get(i) > res.get(i+1)){
                if(first == null){
                    first = res.get(i);
                }
                second = res.get(i+1);
            }
        }

        fix(root, first, second);
    }

    public void fix(TreeNode root, int first, int second){
        if(root == null) return;

        if(root.val == first || root.val == second){
            root.val = (root.val == first) ? second : first;
        }

        fix(root.left, first, second);
        fix(root.right, first, second);
    }
}