class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = profits.length;
        int [][]arr = new int[n][2];

        for( int i=0; i<n; i++ ){
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(
            (b,a)->{
                return Integer.compare(a,b);
            }
        );

        int idx = 0; //curr reach

        for( int i=0; i<k; i++ ){
    
            while( idx<n && arr[idx][1] <= w ){
                maxpq.add(arr[idx][0]);
                idx++;
            }

            if( maxpq.isEmpty() ) break;

            w += maxpq.poll();

        }

        return w;

    }
}