package com.company.linklist;

public class SLLHelperFunctions {
    static SLLHelperFunctions instance;
    private  SLLHelperFunctions() {
    }

    public static SLLHelperFunctions getInstance() {
        if (instance == null) {
            instance = new SLLHelperFunctions();
        }
        return  instance;
    }

    public void AddNode(SllNode head, int data) {
        if(head == null) {
            head = new SllNode(data);
        } else {
            while (head.next!= null) {
                head = head.next;
            }
            head.next = new SllNode(data);
        }
    }

    public void print(SllNode head) {
        while(head != null) {
            System.out.print(head.data + " \t");
            head = head.next;
        }
        System.out.println("\n");
    }

    public SllNode getMiddleNode(SllNode head) {
        SllNode slowPtr = head;
        SllNode fastPtr = head.next; // Initiating fast pointer with next node to return the n/2 element when n is an even number
        while (fastPtr!= null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public int length(SllNode head) {
        int count =0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
