class Solution {
    int []arr;
    int []mul;

    Map<String,Integer> dp;
    int [][]dp1 ;

    int sol(int i, int l, int r){
        if(i==mul.length) return 0;

        int max = Math.max(
            arr[l]*mul[i]+sol(i+1,l+1,r),
            arr[r]*mul[i]+sol(i+1,l,r-1)
        );

        return max;
    }

    //O(m^3) , m=10^2
    int sol1(int i, int l, int r){
        if(i==mul.length) return 0;

        String key = i+"-"+l+"-"+r;
        if(dp.containsKey(key)) return dp.get(key);

        int max = Math.max(
            arr[l]*mul[i]+sol1(i+1,l+1,r),
            arr[r]*mul[i]+sol1(i+1,l,r-1)
        );

        dp.put(key,max);
        return max;
    }


    int sol_OP(int i, int l){
        if(i==mul.length) return 0;
        if(dp1[i][l] != Integer.MIN_VALUE ) return dp1[i][l];

        int r =  (arr.length-1) - (i - l);
        int max = Math.max(
            arr[l]*mul[i]+sol_OP(i+1,l+1),
            arr[r]*mul[i]+sol_OP(i+1,l)
        );

        return dp1[i][l] = max;
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        arr = nums;
        mul = multipliers;

        // O(m^3) BruteForce
        // dp = new HashMap<>();
        // return sol1(0,0,nums.length-1);

        //O(m^2) ,State compressed (i.e. r = nums.length-i-1)
        // return sol_OP(0,0);
        
        int m = multipliers.length;
        dp1 = new int[m][m];
        for(int i=0; i<m ;i++)
            Arrays.fill(dp1[i],Integer.MIN_VALUE);
        return sol_OP(0,0);
    }
}