class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        s.rotateRight(head,2);

    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int r = k % length;
        if (r == 0) return head;
        cur = head;
        ListNode zero = new ListNode(0, head);
        while (cur != null) {
            if (length - r == 0) {
                zero.next = cur;
                while (r-1 > 0) {
                    r--;
                    cur = cur.next;
                }
                cur.next = head;
                break;
            }
            if(length - r == 1){
                ListNode temp=cur.next;
                cur.next=null;
                cur=temp;
            }else {
                cur = cur.next;
            }
            length--;
        }
        return zero.next;
    }
}
