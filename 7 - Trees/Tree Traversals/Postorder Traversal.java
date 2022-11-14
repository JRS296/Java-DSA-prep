class PostOrderTraversal {
    public List<Integer> PostOrder(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
            
        preHelper(root.left, pre);
        preHelper(root.right, pre);
        pre.add(root.val);
    }
}