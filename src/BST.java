import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Isabel Prado-Tucker
 * @version: 4/21/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return findVal(val, root);
    }

    /**
     * Helper method to find value in tree
     * @param val value trying to find in tree
     * @param node current node
     * @return
     */
    public boolean findVal(int val, BSTNode node) {
        // Base case: return false if have gotten to the end and no value
        if (node == null) {
            return false;
        }
        // Return true if the current node contains the value
        else if (node.getVal() == val) {
            return true;
        }
        // Recursive step:
        // Look at left if val is smaller, right if val is greater
        else if (node.getVal() > val) {
            return findVal(val, node.getLeft());
        }
        else {
            return findVal(val, node.getRight());
        }
    }

    /**
     * Inorder traversal
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> inorder = new ArrayList<BSTNode>();
        helperInorder(inorder, root);
        return inorder;
    }

    /**
     * Helper method for inorder: left, root, right
     * @param inorder arraylist adding to
     * @param node current node in tree
     */
    public void helperInorder(ArrayList<BSTNode> inorder, BSTNode node) {
        // Base case: end method once have gone through each node
        if (node == null) {
            return;
        }
        helperInorder(inorder, node.getLeft()); // Recurse towards the left
        inorder.add(node); // Add current node
        helperInorder(inorder, node.getRight()); // Recuse towards the right
    }

    /**
     * Preorder traversal
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> preorder = new ArrayList<BSTNode>();
        helperPreorder(preorder, root);
        return preorder;
    }

    /**
     * Helper method for inorder: root, left, right
     * @param preorder arraylist adding to
     * @param node current node in tree
     */
    public void helperPreorder(ArrayList<BSTNode> preorder, BSTNode node) {
        // Base case: end method once have gone through each node
        if (node == null) {
            return;
        }
        preorder.add(node); // Add current node
        helperPreorder(preorder, node.getLeft()); // Recurse towards the left
        helperPreorder(preorder, node.getRight()); // Recuse towards the right
    }

    /**
     * Postorder traversal
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postorder = new ArrayList<BSTNode>();

        helperPostorder(postorder, root);
        return postorder;
    }

    /**
     * Helper method for postorder: left, right, root
     * @param postorder arraylist adding to
     * @param node current node in tree
     */
    public void helperPostorder(ArrayList<BSTNode> postorder, BSTNode node) {
        // Base case: end method once have gone through each node
        if (node == null) {
            return;
        }
        helperPostorder(postorder, node.getLeft()); // Recurse towards the left
        helperPostorder(postorder, node.getRight()); // Recuse towards the right
        postorder.add(node); // Add current node
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        helperInsert(val, root);
    }

    /**
     * Helper method for insert
     * @param val value being added
     * @param node current node looking at
     */
    public void helperInsert(int val, BSTNode node) {
        // Base case: if node is null, set to new node with the value
        if (node == null) {
            node = new BSTNode(val);
            return;
        }
        // Is value is less than the current node's value
        if (node.getVal() > val) {
            // If no smaller value below current node, add new node to the left
           if (node.getLeft() == null) {
               node.setLeft(new BSTNode(val));
           }
           // Run again on left node
           else {
               helperInsert(val, node.getLeft());
           }

        }
        // Is value is greater than the current node's value
        else {
            // If no greater value below current node, add new node to the right
           if (node.getRight() == null) {
               node.setRight(new BSTNode(val));
           }
           // Run again on right node
           else {
               helperInsert(val, node.getRight());
           }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
