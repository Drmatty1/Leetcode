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
    boolean isCritical(ListNode head, ListNode prev , ListNode next){
        if( (head.val > prev.val && head.val > next.val) || 
            (head.val < prev.val && head.val < next.val)
        ) return true;
        return false;
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int i=0;
        int min = Integer.MAX_VALUE, max = 0;
        int first = -1, last = -1;

        ListNode prev = head;
        head = head.next;
        while( head.next != null ){
            if( isCritical(head, prev , head.next) ) {
                if( first == -1 ){
                    first = i;
                    last = i;
                }
                else{
                    min = Math.min(min, i-last);
                    max = Math.max( max, i-first );
                    last = i;
                }
            }
            prev = head;
            head = head.next;
            i++;
        }

        if( max == 0 ) return new int[]{-1,-1};;
        return new int[]{min, max};
    }
}