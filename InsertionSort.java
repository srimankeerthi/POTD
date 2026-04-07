public class SLL {
    static class Node {
        int data;
        Node next;
        Node(int data) { 
			this.data = data; 
		}
    }

    private Node head;

    public void insertatbeg(int data) {
		Node n = new Node(data);
		if(head == null){
			head = n;
			return;
		}
		else{
			n.next = head;
			head = n;
		}
    }

    public void insertatend(int data) {
        Node n = new Node(data);
        if (head == null) { 
			head = n; 
			return; 
		}
        Node temp = head;
        while (temp.next != null) 
			temp = temp.next;
        temp.next = n;
    }

    public void insertatmid(int data, int position) {
        if (position <= 1 || head == null) {
            insertatbeg(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next = n;
    }

    public void deleteatbeg() {
        if (head == null) { 
			System.out.println("List is empty."); 
			return; 
		}
        head = head.next;
    }

    public void deleteatend() {
        if (head == null) { 
			System.out.println("List is empty."); 
			return; 
		}
        if (head.next == null) { 
			head = null; return; 
		}
        Node temp = head;
        while (temp.next.next != null) 
			temp = temp.next;
        temp.next = null;
    }

    public void deleteatmid(int position) {
        if (head == null) { 
			System.out.println("List is empty."); 
			return; 
		}
        if (position <= 1) { 
			deleteatbeg(); 
			return; 
		}
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range.");
            return;
        }
        temp.next = temp.next.next;
    }

    public void traverse() {
        if (head == null) { 
			System.out.println("List is empty."); 
			return; 
		}
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SLL list = new SLL();

        list.insertatbeg(10);
        list.insertatend(20);
        list.insertatend(30);		
        list.insertatmid(15, 2);
		
        System.out.println("After insertions:");
        list.traverse();
		
        list.deleteatbeg();
        System.out.println("\nAfter deleteatbeg:");
        list.traverse();
		
        list.deleteatmid(2);
        System.out.println("\nAfter deleteatmid(2):");
        list.traverse();
		
        list.deleteatend();
        System.out.println("\nAfter deleteatend:");
        list.traverse();
    }
}