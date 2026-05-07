class Solution_gfg_37{
    public boolean isSubTree(Node root1, Node root2) {
        // If the main tree is null, root2 cannot be a subtree
        if (root1 == null) return false;
        
        // If root2 is null, it's technically a subtree of any tree
        if (root2 == null) return true;

        // 1. If current nodes match, check if trees are identical
        if (isIdentical(root1, root2)) {
            return true;
        }

        // 2. Otherwise, recursively check left and right children of root1
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    // Helper function to check if two trees are exactly the same
    private boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.data == b.data) 
            && isIdentical(a.left, b.left) 
            && isIdentical(a.right, b.right);
    }
}
