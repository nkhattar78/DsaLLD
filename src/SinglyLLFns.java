public class SinglyLLFns {
    NodeSll mergeSortedLists(SingleLL[] lists) {
        NodeSll result = null;
        while(true) {
            break;
        }
        return result;
    }

    NodeSll merge2Lists(NodeSll node1, NodeSll node2) {        
        NodeSll currentNode,head = null;
        if ((node1 == null) && (node2 == null)) {
            return null;
        } else if (node1 == null){
            return node2;
        } else if (node2 == null) {
            return node1;
        } else {
            if(node1.data<=node2.data){
                currentNode = new NodeSll(node1.data);                
                node1 = node1.next;
            } else {
                currentNode = new NodeSll(node2.data);
                node2 = node2.next;
            }
            head = currentNode;
        }

        while((node1 != null) || (node2 != null)) {
            if (node1 == null) {
                copyLIst(node2, currentNode);
                break;
            }
            if (node2 == null) {
                copyLIst(node1, currentNode);
                break;
            }
            if (node1.data<node2.data){                
                copyNode(node1, currentNode);
                node1 = node1.next;
                } else{
                        copyNode(node2, currentNode);
                        node2 = node2.next;
                    }
            }
            return head;
        }

    private void copyNode(NodeSll sourcenode, NodeSll destNode) {
        NodeSll newNode = new NodeSll(destNode.data);
        destNode.next = newNode;
        destNode = destNode.next;
    }
    
    private void  copyLIst(NodeSll sourceList, NodeSll destList) {
        while(sourceList != null) {
            NodeSll newNode = new NodeSll(sourceList.data);
            destList.next = newNode;
            destList = destList.next;
            sourceList = sourceList.next;
        }
    }

    public void printList(NodeSll head) {
        NodeSll currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data + "\t");
            currentNode = currentNode.next;
        }
    }
}
