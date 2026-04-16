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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=l1;
        while(l1!=null && l2!=null){
            int sum=0;
            sum += l1!=null?l1.val:0;
            sum += l2!=null?l2.val:0;
            sum+=carry;
            carry=sum/10;
            sum=sum%10;
            l1.val=sum;
            if( l1.next == null ){
                l1.next=l2.next;
                if( carry!=0 && l2.next==null ){
                    l1.next = new ListNode(carry);
                    l1=l1.next;
                }
                l1=l1.next;
                break;
            }
            l1=l1.next;
            l2=l2.next;
            
        }
        while(l1!=null){
            int sum=0;
            sum += l1!=null?l1.val:0;
            sum+=carry;
            carry=sum/10;
            sum=sum%10;
            l1.val=sum;
            if( l1.next == null ){
                if( carry!=0 ){
                    l1.next = new ListNode(carry);
                }
                break;
            }
            l1=l1.next;
        }
        
        return head;

    }
}