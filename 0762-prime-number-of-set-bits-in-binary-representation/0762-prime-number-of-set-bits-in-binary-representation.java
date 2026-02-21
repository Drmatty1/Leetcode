class Solution {
    int countbits(int n){
        int count=0;
        while(n!=0){
            count += n&1;
            n=n>>1;
        }
        return count;
    }
    boolean isPrimeSet(int n){
        switch(n){
            case 2:return true;
            case 3:return true;
            case 5:return true;
            case 7:return true;
            case 11:return true;
            case 13:return true;
            case 17:return true;
            case 19:return true;
            default: return false;
        }
    }
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left; i<=right; i++){
            if(isPrimeSet(countbits(i)))count++;
        }
        return count;
    }
}