class Solution {
    boolean sol(int []a, int i, int j, long diff){
        if(i==j) return (diff+a[i]>=0);
        if(i>j ) return diff>=0;

        boolean p=false, b=false, c=false, d=false;
        // System.out.println(i+" "+j+" "+diff);

        p = sol(a,i+1,j-1,diff+a[i]-a[j]);
        if(i+1 < a.length)
            b = sol(a,i+2,j,diff+a[i]-a[i+1]);
        c = sol(a,i+1,j-1,diff+a[j]-a[i]);
        if(j-1 >= 0)
            d = sol(a,i,j-2,diff+a[j]-a[j-1]);
        
        return p&&b || c&&d;
    }
    public boolean predictTheWinner(int[] nums) {
        return sol(nums,0,nums.length-1,0);
    }
}