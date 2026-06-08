/* Structure of linked list node
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution_gfg_73 {
    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Reverse the linked list
        head = reverse(head);
        
        // Step 2: Traverse and remove nodes with smaller values
        Node current = head;
        Node maxNode = head;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                // Skip the next node because it's smaller than the max seen so far
                current.next = current.next.next;
            } else {
                // Move current pointer and update the max node
                current = current.next;
                maxNode = current;
            }
        }
        
        // Step 3: Reverse the list again to restore original order
        return reverse(head);
    }
    
    // Helper function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
