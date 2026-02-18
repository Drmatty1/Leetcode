class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length, ans = 0 ;
        long sum = 0, tank = 0 ;   

        for( int i=0; i<n; i++ ){

            sum += gas[i]-cost[i];
            tank += gas[i]-cost[i];

            if( tank < 0 ){ 
                tank = 0;
                ans = (i+1);
            }
            
        }
        return sum<0?(-1):ans;
    }
}









