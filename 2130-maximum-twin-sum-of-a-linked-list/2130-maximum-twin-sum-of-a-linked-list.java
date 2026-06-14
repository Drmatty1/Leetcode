/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow;


        ListNode tail = head2, curr = head2.next;
        while(curr != null){
            ListNode next = curr.next;

            tail.next = curr.next;
            curr.next = head2;
            
            head2 = curr;
            curr = next;
        }


        int ans = 0;
        while( head2 != null ){
            ans = Math.max(ans, head.val+head2.val);
            head =  head.next;
            head2 =  head2.next;
        }

        return ans;

    }
}