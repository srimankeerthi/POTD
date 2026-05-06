class Solution_gfg_34 {
    public int getSize(Node root) {
        // Base case: if the tree is empty, size is 0
        if (root == null) {
            return 0;
        }
        
        // Total size = 1 (current node) + size of left + size of right
        return 1 + getSize(root.left) + getSize(root.right);
    }
}
