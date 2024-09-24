package com.company.linklist;

public class LinkListOrderingProblems {
    public static SllNode reverse(SllNode head) {
        if (head == null || head.next == null) {
            return  head;
        }
        SllNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void printInReverseOrder(SllNode head) {
        if (head == null) {
            return;
        }
        printInReverseOrder(head.next);
        System.out.print(head.data + " ");
    }
}
