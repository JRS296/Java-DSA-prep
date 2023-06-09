package BTrees;

// Java code to Find maximum (or minimum) in Binary Tree

// A binary tree node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Returns the max value in a binary tree
    int findMax(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    // Returns the min value in a binary tree
    int findMin(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.data;
        int lres = findMin(node.left);
        int rres = findMin(node.right);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    /* Driver code */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        // Function call
        System.out.println("Maximum element is "+ tree.findMax(tree.root));
        System.out.println("Minimum element is "+ tree.findMin(tree.root));
    }
}


/*
Time Complexity: O(N).
In the recursive function calls, every node of the tree is processed once and hence 
the complexity due to the function is O(N) if there are total N nodes in the tree. 
Therefore, the time complexity is O(N).

Space Complexity: O(N).
Recursive call is happening. The every node is processed once and considering the 
stack space, the space complexity will be O(N).
 */