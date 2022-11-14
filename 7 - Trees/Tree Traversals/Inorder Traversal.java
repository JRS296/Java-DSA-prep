class inOrderTraversal {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null)
            return;
        preHelper(root.left, pre);
        pre.add(root.val);
        preHelper(root.right, pre);
    }
}