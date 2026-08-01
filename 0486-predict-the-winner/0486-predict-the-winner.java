class Solution {
    boolean sol1(int []a, int i, int j, long diff){
        if(i==j) return (diff+a[i]>=0);
        if(i>j ) return diff>=0;

        boolean p=false, b=false, c=false, d=false;
        // System.out.println(i+" "+j+" "+diff);

        p = sol1(a,i+1,j-1,diff+a[i]-a[j]);
        if(i+1 < a.length)
            b = sol1(a,i+2,j,diff+a[i]-a[i+1]);
        c = sol1(a,i+1,j-1,diff+a[j]-a[i]);
        if(j-1 >= 0)
            d = sol1(a,i,j-2,diff+a[j]-a[j-1]);
        
        return p&&b || c&&d;
    }

    int sol2(int []arr, int i, int j){
        if(i==j) return arr[i];

        int a = arr[i] - sol2(arr,i+1,j);
        int b = arr[j] - sol2(arr,i,j-1);

        return Math.max(a,b);
    }

    public boolean predictTheWinner(int[] nums) {
        // return sol(nums,0,nums.length-1,0);

        return sol2(nums,0,nums.length-1)>=0;
    }
}