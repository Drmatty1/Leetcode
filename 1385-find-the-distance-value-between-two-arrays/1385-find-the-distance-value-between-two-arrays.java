class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int e: arr1){
            boolean flag =  true;
            for(int q: arr2){
                if(Math.abs(e-q)<=d){
                    flag = false;
                    break;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}