class Solution {
    int c(int n){
        int check = 0;
        while(n>0){
            int t = n%10;
            if(t==2||t==5||t==6||t==9) check=1;
            if( t==3||t==4||t==7)return 0;
            n = n/10;
        }
        return check;
    }
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i=2; i<=n; i++)ans+=c(i);
        return ans;
    }
}