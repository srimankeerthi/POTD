import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

/* Structure of binary tree node
class Node{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution_gfg_62 {
    public ArrayList<Integer> verticalSum(Node root) {
        // TreeMap to store the sum of nodes at each horizontal distance (hd)
        // TreeMap keeps keys sorted, so we get left-to-right order automatically
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Helper function to perform DFS traversal
        calculateVerticalSum(root, 0, map);
        
        // Convert the map values to the required ArrayList output
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
    
    private void calculateVerticalSum(Node node, int hd, TreeMap<Integer, Integer> map) {
        // Base case
        if (node == null) {
            return;
        }
        
        // Add current node's data to its corresponding horizontal distance sum
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        
        // Recur for left subtree with hd - 1
        calculateVerticalSum(node.left, hd - 1, map);
        
        // Recur for right subtree with hd + 1
        calculateVerticalSum(node.right, hd + 1, map);
    }
}
