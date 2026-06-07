import java.util.*;

class Solution_leet_71 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store created TreeNode objects mapped to their integer values
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Set to track all nodes that are children
        Set<Integer> childrenSet = new HashSet<>();
        
        // Step 1: Build the tree and track children
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];
            
            // Get or create parent node
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parentNode = nodeMap.get(parentVal);
            
            // Get or create child node
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode childNode = nodeMap.get(childVal);
            
            // Link parent and child
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            // Mark this node as a child
            childrenSet.add(childVal);
        }
        
        // Step 2: Find the root (the node that is never a child)
        for (int parentVal : nodeMap.keySet()) {
            if (!childrenSet.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }
        
        return null; // Fallback for an empty or invalid description list
    }
}
