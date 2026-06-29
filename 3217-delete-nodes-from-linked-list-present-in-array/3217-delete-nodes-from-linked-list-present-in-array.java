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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set=  new HashSet<>();
        for(int e: nums)set.add(e);

        ListNode curr = head;
        while( curr != null && set.contains(curr.val) ) curr = curr.next;

        ListNode newHead = curr;
        ListNode prev = curr;
        curr = curr.next;
        while( curr != null ){
            if( set.contains(curr.val) ){
                prev.next = curr.next;
                curr = curr.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }

        return newHead;
    }
}