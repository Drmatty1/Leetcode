class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int r = (int)1e5+1;
        int []arr = new int[r];

        for(int e: costs) arr[e]++;

        int ans = 0;

        for(int i=1; i<r; i++){
            if( arr[i]*i > coins ){
                ans += coins/i;
                break;
            }
            else{ 
                ans += arr[i];
                coins -= i*arr[i];
            }
        }

        return ans;

    }
}