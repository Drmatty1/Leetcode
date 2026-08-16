class Solution {
    boolean sol(int curr,int a, int b, int c, int n){
        n--;
        int turn = 0; //bob
        while(n-->0){
            if(curr==1){
                if(a>0) a--;
                else if(b>0){
                    b--;
                    curr++;
                }
                else if(c>0){
                    return turn==0?true:false;
                }
                else{
                    return false;
                }
            }
            else if(curr==2){
                if(a>0) a--;
                else if(c>0){
                    c--;
                    curr--;
                }
                else if(b>0){
                    return turn==0?true:false;
                }
                else{
                    return false;
                }
            }
            turn = 1-turn;
        }
        return false;
    }
    public boolean stoneGameIX(int[] stones) {

        int a=0,b=0,c=0;
        int n = stones.length;

        for(int s: stones) {
            if(s%3 == 0) a++;
            else if(s%3 == 1) b++;
            else c++;
        }

        //m-OP
        if(a%2==0){
            return Math.min(b,c)>0;
        }
        return Math.abs(b-c)>2;

        // m-1
        // boolean case1 = b>0?sol(1,a,b-1,c,n):false;
        // boolean case2 = c>0?sol(2,a,b,c-1,n):false;
        // return case1||case2;

    }
}           