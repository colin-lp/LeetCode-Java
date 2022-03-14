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
        Solution solution=new Solution();
        ListNode listNode1=new ListNode(
            1,new ListNode(
            2,new ListNode(
            3,new ListNode(
            4,new ListNode(5)))));

        ListNode node=solution.reverseKGroup(listNode1, 2);
        System.out.println(" ");
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            tempNode = tempNode.next;
            length++;
        }

        int times = length / k;
        if(times==0) return head;
        ListNode dummy=new ListNode();
        ListNode preHead = new ListNode();
        ListNode pre = new ListNode();
        ListNode cur = head;
        boolean first=true;

        while (times != 0) {
            // 1 2 3 4 5 6
            ListNode preRear=cur;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if(first){
                dummy.next=pre;
                first=false;
            }
            preHead.next=pre;
            preRear.next=cur;
            preHead=preRear;
            times--;
        }

        return dummy.next;

    }
}
