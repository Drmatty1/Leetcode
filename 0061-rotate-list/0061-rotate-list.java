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
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null ) return head;
        int n = 0 ;
        ListNode temp = head;
        while( temp != null ) {
            temp = temp.next;
            n++;
        }
        int rotate = k%n;
        if( rotate == 0 ) return head;

        // if to be rotated >1 
        ListNode a = head, b=head ;
        while( rotate-- > 0 ){
            b = b.next;
        }
        while( b.next != null ){
            b = b.next;
            a = a.next;
        }
        ListNode newHead = a.next;
        a.next = null;
        b.next = head;
        return newHead;
    }
}














