class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length, ans = -1 ;
        long sum = 0, max = 0 ; 
        
        long checksum = 0;
        for( int i=n-1; i>=0; i-- ) checksum+=gas[i]-cost[i];
        if( checksum<0 )return -1;

        int streak=0;
        for( int i=0; i<2*n-1; i++ ){
            sum += gas[i%n]-cost[i%n];
            if( sum < 0 ){ 
                sum=0;
                streak = i+1;
            }
    
            if( sum >= max ){
                max = sum;
                ans = streak%n;
            }
            
        }
        return ans;
    }
}









