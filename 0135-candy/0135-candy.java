class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if( n==1 )return 1;

        int []ans = new int[n];


        ans[0] = 1;
        for(int i=1; i<n; i++){

            if( ratings[i] > ratings[i-1] ){
                ans[i] = Math.max(ans[i],ans[i-1]+1);
            }
            else{
                ans[i] = Math.max(ans[i],1);
            }
            
        }

        for(int i=n-2; i>=0; i--){
 
            if( ratings[i] > ratings[i+1] ){
                ans[i] = Math.max(ans[i],ans[i+1]+1);
            }
            else{
                ans[i] = Math.max(ans[i],1);
            }
            
        }

        int sum = 0;
        for(int e: ans) sum += e;
        return sum;
    }
}