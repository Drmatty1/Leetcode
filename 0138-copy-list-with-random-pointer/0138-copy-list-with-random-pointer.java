/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Integer> ntp = new HashMap<>();
        Map<Integer,Node> ptn = new HashMap<>();

        Node head2 = new Node(-1);

        Node curr = head2 ;  // dummy node
        Node temp = head;
        int pos = 1;
        while(temp != null){
            curr.next = new Node(temp.val);
            curr = curr.next;

            // here curr and temp both point to same pos
            ntp.put(temp,pos);
            ptn.put(pos,curr);
            pos++;

            temp = temp.next;

        }

        head2 = head2.next;
        
        Node c1 = head;
        Node c2 = head2;
        while(c1 != null){
            int p = ntp.getOrDefault(c1.random,-1);
            if( p > 0 ){
                c2.random = ptn.get(p);
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return head2;
    }
}