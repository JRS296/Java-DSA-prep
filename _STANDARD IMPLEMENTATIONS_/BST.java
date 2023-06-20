class Program { //ALE
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      insertHelper(this, value);
      return this;
    }

    public BST insertHelper(BST btree, int value) {
      if(btree == null) return new BST(value);

      if(value < btree.value) btree.left = insertHelper(btree.left, value);
      else btree.right = insertHelper(btree.right, value);

      return btree;
    }

    public boolean contains(int value) {
      return containsHelper(this, value);
    }

    public boolean containsHelper(BST btree, int value) {
      if(btree == null) return false;

      if(btree.value == value) return true; 
      else if (value < btree.value) return containsHelper(btree.left, value);
      else return containsHelper(btree.right, value);
    }

    public BST remove(int value) {
      removeHelper(this,value);
      return this;
    }

    public BST removeHelper(BST btree, int value) {
      if(btree == null) return btree;

      if(value < btree.value) btree.left = removeHelper(btree.left, value);
      else if (value > btree.value) btree.right = removeHelper(btree.right, value);
      else {
        //If no children -> delete
        if(btree.right == null && btree.left == null) return null;

        //If only 1 child -> replace it with child
        if(btree.left != null && btree.right == null) {
          btree.value = btree.left.value;
          btree.right = btree.left.right;
          btree.left = btree.left.left;
          return btree;
        }
        if(btree.right != null && btree.left == null) {
          btree.value = btree.right.value;
          btree.left = btree.right.left;
          btree.right = btree.right.right;
          return btree;
        }

        //If 2 children -> replace with smallest value in right side of tree
        if(btree.right != null && btree.left != null) {
          int smallest = smallestValue(btree.right);
          btree.value = smallest;
          btree.right = removeHelper(btree.right, smallest);
          return btree;
        }
      }
      return btree;
    }

    public int smallestValue(BST btree) {
      return btree.left == null ? btree.value : smallestValue(btree.left);
    }

    public int largestValue(BST btree) {
      return btree.right == null ? btree.value : largestValue(btree.right);
    }
  }
}

// Another Implementation

class BST_class { 
    //node class that defines BST node
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    // BST root node 
    Node root; 
  
   // Constructor for BST =>initial empty tree
    BST_class(){ 
        root = null; 
    } 
    //delete a node from BST
    void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   
    //recursive delete function
    Node delete_Recursive(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.key)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.key = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(Node root)  { 
        //initially minval = root
        int minval = root.key; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
    // insert a node in BST 
    void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
   
    //recursive insert function
    Node insert_Recursive(Node root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key); 
          // return pointer
        return root; 
    } 
 
// method for inorder traversal of BST 
    void inorder() { 
        inorder_Recursive(root); 
    } 
   
    // recursively traverse the BST  
    void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
     
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive insert function
    Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
}
class Main{
    public static void main(String[] args)  { 
       //create a BST object
        BST_class bst = new BST_class(); 
        /* BST tree example
              45 
           /     \ 
          10      90 
         /  \    /   
        7   12  50   */
        //insert data into BST
        bst.insert(45); 
        bst.insert(10); 
        bst.insert(7); 
        bst.insert(12); 
        bst.insert(90); 
        bst.insert(50); 
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right):"); 
        bst.inorder(); 
        
        //delete leaf node  
        System.out.println("\nThe BST after Delete 12(leaf node):"); 
        bst.deleteKey(12); 
        bst.inorder(); 
        //delete the node with one child
        System.out.println("\nThe BST after Delete 90 (node with 1 child):"); 
        bst.deleteKey(90); 
        bst.inorder(); 
                 
        //delete node with two children  
        System.out.println("\nThe BST after Delete 45 (Node with two children):"); 
        bst.deleteKey(45); 
        bst.inorder(); 
        //search a key in the BST
        boolean ret_val = bst.search (50);
        System.out.println("\nKey 50 found in BST:" + ret_val );
        ret_val = bst.search (12);
        System.out.println("\nKey 12 found in BST:" + ret_val );
     } 
}