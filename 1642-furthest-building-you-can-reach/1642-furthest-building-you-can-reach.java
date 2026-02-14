class Solution {
    boolean check(int[] arr, int bricks, int ladders, int mid){
     
        int []help = new int[mid+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(arr[b+1]-arr[b],arr[a+1]-arr[a]);
        });
        for( int i=0; i<mid; i++ ) pq.add(i);
        for( int i=0; i<mid; i++ ){
            int idx = pq.poll();
            if( arr[idx] >= arr[idx+1] ) return true;
            if( ladders != 0 ){
                help[idx] = 1;
                ladders--;
            }
            else break;
        }

        for( int i=0; i<mid; i++ ){
            if( help[i] == 1 || arr[i] >= arr[i+1] )continue;

            if( arr[i+1] - arr[i] <= bricks ) bricks -= arr[i+1] - arr[i];
            else return false;
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