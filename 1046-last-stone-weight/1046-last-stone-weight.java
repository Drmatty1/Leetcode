class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(
            (a,b)->Integer.compare(b,a)
        );
        for( int e : stones ) maxpq.add(e);
        while( maxpq.size() > 1 ){
            int a = maxpq.poll();
            int b = maxpq.poll();
            if( a != b ) maxpq.add( a - b );
        }
        if( maxpq.isEmpty() ) return 0;
        return maxpq.poll();
    }
}