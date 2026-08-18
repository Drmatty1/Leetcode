class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long []diff = new long[n];
        for(int []b: boosts){
            int l=b[0], r=b[1], v=b[2];
            diff[r]+=v;
            if(l-1>=0) diff[l-1]-=v;
        }

        long needLater = 0, bonus=0;

        for(int i=n-1; i>=0; i--){

            bonus += diff[i];

            if(needLater > 0) needLater += monsters[i];
            else{
                needLater = Math.max(0,monsters[i]-bonus);
            }
        }

        return needLater;
    }
}