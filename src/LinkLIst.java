public class LinkLIst {
    class LinklistNode {
        int data;
        LinklistNode next;

        LinklistNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    LinklistNode head;
    LinklistNode tail;


    LinkLIst() {
        this.head = null;
        this.tail = null;
    }

    LinkLIst(LinklistNode node) {
        this.head = node;
        this.tail = node;
    }

    LinkLIst(int data) {
        LinklistNode node = new LinklistNode(data);
        this.head = node;
        this.tail = node;
    }

    LinkLIst (int[] arr) {
        if (arr.length ==0) {
            this.head = null;
            return;
        }

        this.head = new LinklistNode(arr[0]);
        LinklistNode current = this.head;
        LinklistNode newNode = null;

        for (int i =1;i<arr.length;i++) {
            newNode = new LinklistNode(arr[i]);
            current.next = newNode;
            current = newNode;
        }
        this.tail = newNode;
    }

    void printLinkList(){
        LinklistNode current = this.head;
        System.out.println("Elements in link list are: ");

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void reverseLinkList() {
        if(this.head == null || this.head.next == null) {
            System.out.println("List has 0 or 1 element and can't be reversed");
            return;
        }

        LinklistNode  prev = this.head;
        LinklistNode current   = this.head.next;
        prev.next = null;
        LinklistNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    void mergeTwoLinklistsInline() {
        int[] arr1 = {1,5,7};
        int[] arr2 = {2,4,6,8,10,12};
//        int[] arr1 = {1,3};
//        int[] arr2 = {2,4};
        LinkLIst list1 = new LinkLIst(arr1);
        LinkLIst list2 = new LinkLIst(arr2);
        LinklistNode current = null, list1Ptr=null, list2Ptr=null;


        if (list1.head.data > list2.head.data) {
            this.head = list2.head;
            current = list2.head;
            list1Ptr = list1.head;
            list2Ptr = list2.head.next;
        } else {
            this.head = list1.head;
            current = list1.head;
            list1Ptr = list1.head.next;
            list2Ptr = list2.head;
        }

        while (list1Ptr!= null && list2Ptr!= null) {
            if (list1Ptr.data > list2Ptr.data) {
                current.next = list2Ptr;
                current = list2Ptr;
                list2Ptr = list2Ptr.next;
            } else {
                current.next = list1Ptr;
                current = list1Ptr;
                list1Ptr = list1Ptr.next;
            }
        }

        if(list1Ptr != null){
            current.next = list1Ptr;
        }

        if (list2Ptr != null) {
            current.next = list2Ptr;
        }

        printLinkList();
    }
}
