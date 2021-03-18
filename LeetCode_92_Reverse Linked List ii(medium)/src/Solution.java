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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode zeroNode = new ListNode(-1);
        zeroNode.next = head;
        ListNode leftPreNode = zeroNode, rightNode;
        for (int i = 0; i < left - 1; i++) {
            leftPreNode = leftPreNode.next;
        }
        rightNode = leftPreNode;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = leftPreNode.next;
        ListNode rightNextNode = rightNode.next;

        leftPreNode.next = null;
        rightNode.next = null;

        reverse(leftNode);

        leftPreNode.next = rightNode;
        leftNode.next = rightNextNode;
        return zeroNode.next;
    }

        private void reverse(ListNode node){
        ListNode pre=null,next=node,temp;
        while(next!=null){
            temp=next.next;
            next.next=pre;
            pre=next;
            next=temp;
        }
    }
}
