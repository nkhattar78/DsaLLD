package linklist;

public class ReverseLinkList {
    public static void mainFn() {
        int[] listData = {1,2,3,4,5,6,7,8,9,10,11};
        SingleLL singleLL = new SingleLL(listData);
        SLLHelperFunctions.getInstance().print(singleLL.head);
//        SllNode head = reverseLinkList(singleLL.head);
//        SLLHelperFunctions.getInstance().print(head);

//        SllNode head = reverseSllRecursive(singleLL.head);
//        SLLHelperFunctions.getInstance().print(head);

        SllNode head = singleLL.head;
        SllNode newHead = reverseInGroups(head, 3);
        SLLHelperFunctions.getInstance().print(newHead);
    }


    protected static SllNode reverseInGroups(SllNode head, int k) {
        SllNode reverseListHead = null;
        SllNode current = head, prevHead = head;
        int groupCount =0;

        while (current!=null) {
            while (groupCount<k && current!=null) {
                current =current.next;
                groupCount++;
            }
            SllNode newHead = reverseSllRecursive(head,groupCount-1);
            if(reverseListHead == null) {
                reverseListHead = newHead;
            }
            prevHead.next=newHead;
            prevHead = head;
            head.next=current;
            head=head.next;
            groupCount=0;
        }
        return reverseListHead;
    }

    private static SllNode reverseLinkList(SllNode head) {
        if (head == null || head.next== null) return head;
        SllNode current=head, next, prev;
        prev=current;
        current=current.next;
        prev.next=null;
        while (current!=null) {
            next=current.next;
            current.next=prev;
            prev =current;
            current=next;
        }
        return prev;
    }

    private static SllNode reverseSllRecursive(SllNode head) {
        if(head==null|| head.next==null) return head;

        SllNode next = reverseSllRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return next;
    }

    private static SllNode reverseSllRecursive(SllNode head, int counter) {
        if(head==null|| head.next==null|| counter==0) return head;

        SllNode next = reverseSllRecursive(head.next, counter-1);
        head.next.next=head;
        head.next=null;
        return next;
    }
}
