class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int n = coins.length;
        int r = 1;
        int count = 0;

        for( int i=0; i<n; i++ ){
            if( r > target ) break;
            if( coins[i] <= r ){
                r += coins[i];
            }
            else{
                r += r;
                count++;
                i--;
            }
        }
    
        while ( r < target+1 ){
            r += r;
            count++;
        }

        return count;
    }
}