/* Structure for Tree Node
class Node {
    int data;
    Node left, right;
    
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution_gfg_57 {
    public void toSumTree(Node root) {
        // Call the helper function to perform the transformation
        transform(root);
    }
    
    private int transform(Node root) {
        // Base case: if node is null, return 0
        if (root == null) {
            return 0;
        }
        
        // Recursively compute the sum of left and right subtrees
        int leftSum = transform(root.left);
        int rightSum = transform(root.right);
        
        // Store the original value of the current node
        int oldVal = root.data;
        
        // Update the current node's value with the sum of its subtrees
        root.data = leftSum + rightSum;
        
        // Return the total sum of the subtree rooted at this node to the parent
        return oldVal + root.data;
    }
}
