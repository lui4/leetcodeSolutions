import java.util.List;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int index = 0;

        while(index != left){
            prev = curr;
            curr = curr.next;
            index++;
        }

        ListNode lastLeftNode = prev;
        ListNode leftNode = curr;

        prev = null;

        while (curr != null) {
            if(index - 1 == right){
                break;
            }
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if(lastLeftNode == null){
            head = prev;
        } else {
            lastLeftNode.next = prev;
        }

        leftNode.next = curr;

        return head;
    }
}
