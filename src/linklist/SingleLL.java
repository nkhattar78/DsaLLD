package linklist;
public class SingleLL {
    SllNode head;
    SllNode tail;
    SingleLL() {

    }
    SingleLL(int data){
        SllNode node = new SllNode(data);
        this.head = node;
        this.tail = node;
    }
    public SingleLL(int[] data){
        if (data.length>0) {
            this.head = new SllNode(data[0]);
            SllNode currentNode = this.head;
            for (int i=1;i<data.length;i++) {
                SllNode newNode = new SllNode(data[i]);
                currentNode.next = newNode;
                currentNode = newNode;
            }
            this.tail = currentNode;
        }
    }

    public SllNode getHead() {
        return this.head;
    }
}
