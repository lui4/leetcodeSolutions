public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        int remainder = 0;
        int tempSum = 0;
        ListNode result = new ListNode();
        ListNode answer = result;

        while (pointer1 != null || pointer2 != null || remainder != 0) {
            if(pointer1 == null && pointer2 == null) {
                result.next = new ListNode(1);
                break;
            } else if(pointer1 == null) {
                tempSum = pointer2.val + remainder;
            } else if(pointer2 == null){
                tempSum = pointer1.val + remainder;
            } else {
                tempSum = pointer1.val + pointer2.val + remainder;
            }

            if(tempSum >= 10){
                remainder = 1;
            } else {
                remainder = 0;
            }

            tempSum -= 10;

            result.next = new ListNode(tempSum);

            result = result.next;
            pointer2 = pointer2.next;
            pointer1 = pointer1.next;
        }

        return answer.next;
    }

}
