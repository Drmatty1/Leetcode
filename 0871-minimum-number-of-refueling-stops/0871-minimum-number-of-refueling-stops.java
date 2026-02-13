class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> arrival = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        PriorityQueue<int[]> fuel = new PriorityQueue<>((a,b)->{
            return Integer.compare(b[1],a[1]);
        });
        for( int[]a : stations ) arrival.add(a);

        int reach=startFuel;
        int count=  0;
        while( reach < target ){
            
            while( !arrival.isEmpty() && arrival.peek()[0]<=reach )
                fuel.add(arrival.poll());
            
            if( fuel.isEmpty() )return -1;

            reach+=fuel.poll()[1];
           count++;
        }
        return count;
    }
}