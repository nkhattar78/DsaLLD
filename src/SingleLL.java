class NodeSll {
    int data;
    NodeSll next;
    
    NodeSll(int data) {
        this.data = data;
        this.next = null;			
    }
}

public class SingleLL {    
    private NodeSll head;

    NodeSll getHead() {
        return this.head;
    }

    SingleLL(int[] data) {
		NodeSll current = null;
        this.head = null;
		for (int i=0;i<data.length;i++) {
			NodeSll node = new NodeSll(data[i]);
			if (i == 0) {
				 this.head = node;
				 current = node;
			} else {
				current.next = node;
				current = current.next;			
			}
		}
    }
	
	public void print() {
        NodeSll currentNode = this.head;
		while (currentNode != null) {
			System.out.print(currentNode.data  + "\t");
			currentNode = currentNode.next;
		}
        System.out.println("\n");
	}
	
	public NodeSll getmiddleNode() {
		NodeSll slowPtr = this.head, fastPtr = this.head;
		
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;			
		}
		return slowPtr;		
	}
}
 