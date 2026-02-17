class Solution {
    class pair{
        int i;
        int j;
        pair(int a, int b){
            i=a;
            j=b;
        }
    }

    public long maxSpending(int[][] values) {
        
        PriorityQueue <pair> pq = new PriorityQueue<>(
            (p1,p2)->{
                return Integer.compare(
                    values[p1.i][p1.j],
                    values[p2.i][p2.j]
                );
            }
        );

        int m = values.length,n = values[0].length;
        for( int i=0; i<m; i++ ){
            pq.add(new pair(i,n-1));
        }

        long day=1;
        long ans= 0;
        while( !pq.isEmpty() ){
            pair c = pq.poll();
            int i = c.i;
            int j = c.j;
            ans += values[i][j]*day;
            if( j-1 >= 0 ) pq.add(new pair(i,j-1));
            day++;
        }
        return ans;
    }
}