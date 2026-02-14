class Solution {
    boolean check(int[] arr, int bricks, int ladders, int mid){
    
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a,b);
        });

        for( int i=0; i<mid; i++ ){
            int diff = arr[i+1]-arr[i];
            if( diff > 0 ){
                pq.add(diff);
                if( pq.size() > ladders ){
                    bricks -= pq.poll();
                    if( bricks < 0 ) return false;
                }
            }
        } 

        return true;

    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int s = 0, e = heights.length-1;
        int mid, ans = 0;
        while( s <= e ){
            mid = (e-s)/2+s;
            if( check(heights,bricks,ladders,mid) ){
                ans = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return ans;
    }
}