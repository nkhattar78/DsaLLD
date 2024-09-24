package linklist;

public class MergeSortedLinksLists {
    public static void mainFn() {
        int[] list1Data = {2,4,6};
        int[] list2Data = {1,3};
        SingleLL list1 = new SingleLL(list1Data);
        SingleLL list2 = new SingleLL(list2Data);
        printLLRecursive(list1.head);
        System.out.println();
        printLLRecursive(list2.head);
        System.out.println();
        SllNode head = mergeSortedLinklists(list1.head, list2.head);
        printLLRecursive(head);
    }

    private static void printLLRecursive(SllNode head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        printLLRecursive(head.next);
    }

    private static SllNode mergeSortedLinklists(SllNode head1, SllNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return  head1;

        SllNode head = null;
        if (head1.data < head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        SllNode current = head;

        while (head1!= null && head2!= null) {
            if (head1.data < head2.data) {
                current.next = head1;
                current = current.next;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            current.next = head2;
        } else if (head2 == null) {
            current.next = head1;
        }

        return head;
    }
}
