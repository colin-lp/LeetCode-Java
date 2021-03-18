public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=head;
        ListNode temp;
        while(next!=null){
            temp=next.next;
            next.next=pre;
            pre=next;
            next=temp;
        }
        return pre;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
