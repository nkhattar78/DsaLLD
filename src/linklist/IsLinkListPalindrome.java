package linklist;

public class IsLinkListPalindrome {
    /* Algorithm
     Find the middle node of the list
     reverse the 2nd half
     Compare the 2 halves
     */

    public static boolean mainFn(SllNode head) {
        SllNode middleNode = SLLHelperFunctions.getInstance().getMiddleNode(head);
        SllNode headOf2ndHalf = LinkListOrderingProblems.reverse(middleNode.next);
        return compare2LinksLists(head, headOf2ndHalf, false);
    }

    static boolean compare2LinksLists(SllNode head1, SllNode head2, boolean listLengthCheck) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if(!listLengthCheck) {
            return true;
        }

        //Checking if either of the list is traversed fully and other is not
        if( (head1 != null || head2 != null)) {
            return false;
        }
        return true;
    }
}
