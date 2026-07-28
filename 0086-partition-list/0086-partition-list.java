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
    void print(ListNode l){
        ListNode c = l;
        while( c != null ){
            System.out.print(c.val+" ");
            c = c.next;
        }
        System.out.println();

    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = head;
        ListNode prev = dummy;

        ListNode dummy1 = new ListNode(0);
        ListNode tail = dummy1;

        while(curr != null){

            if(curr.val >= x){
                tail.next = curr;
                tail = tail.next;

                prev.next = curr.next;
                curr = curr.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }

        // print(dummy);
        // print(dummy1);
        
        tail.next = null;

        //now prev point to tail of 1st ll
        prev.next = dummy1.next;

        return dummy.next;
    }
}