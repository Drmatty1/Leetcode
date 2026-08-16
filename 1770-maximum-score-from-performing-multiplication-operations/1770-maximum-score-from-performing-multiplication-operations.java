class Solution {
    int []arr;
    int []mul;

    Map<String,Integer> dp;

    int sol(int i, int l, int r){
        if(i==mul.length) return 0;

        int max = Math.max(
            arr[l]*mul[i]+sol(i+1,l+1,r),
            arr[r]*mul[i]+sol(i+1,l,r-1)
        );

        return max;
    }

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

    public int maximumScore(int[] nums, int[] multipliers) {
        arr = nums;
        mul = multipliers;

        // return sol(0,0,nums.length-1);

        dp = new HashMap<>();
        return sol1(0,0,nums.length-1);

    }
}