package linklist;

class NodeDoublyLL {
    int data;
    NodeDoublyLL next;
    NodeDoublyLL prev;
    NodeDoublyLL(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoublyLL {
    NodeDoublyLL head;
    NodeDoublyLL tail;
    DoublyLL() {
    }

    DoublyLL(int data) {
        NodeDoublyLL node = new NodeDoublyLL(data);
        this.head = node;
        this.tail = node;
    }

    DoublyLL(int[] data) {
        if (data.length>0) {
            this.head = new NodeDoublyLL(data[0]);
            NodeDoublyLL currentNode = this.head;
            for (int i=1;i<data.length;i++) {
                NodeDoublyLL newNode = new NodeDoublyLL(data[i]);
                currentNode.next = newNode;
                newNode.prev = currentNode;
                currentNode = newNode;
            }
            this.tail = currentNode;
        }
    }

    void print() {
        NodeDoublyLL node = this.head;
        while(node != null) {
            System.out.print(node.data + " \t");
            node = node.next;
        }
        System.out.println("\n");
    }

    void addNode(int data) {
        NodeDoublyLL node = new NodeDoublyLL(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
}
