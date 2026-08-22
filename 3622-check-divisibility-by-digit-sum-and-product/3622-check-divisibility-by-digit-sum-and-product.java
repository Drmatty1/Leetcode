class Solution {
    public boolean checkDivisibility(int n) {
        int k=n;
        int s=0,p=1;

        while(k>0){
            s += k%10;
            p *= k%10;
            k /= 10;
        }
        
        return (n%(s+p)==0);
    }
}