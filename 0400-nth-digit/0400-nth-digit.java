class Solution {
    public int findNthDigit(int n) {
        int k = n;

        if(k<=9) return k;

        k-=9;
        long d = 2;
        
        while(true){

            long grpCnt = 9*((long)(Math.pow(10,d-1))) ;
            long total = grpCnt*d;

            if(total >= k ) break;

            k -= total;

            d++;

        }

        long k0 = k-1;  // 0-based index

        long pos = k0/d;    
        long digIndex = k0%d;

        long base = ((long)(Math.pow(10,d-1))) ;
        long no = base+pos;
        String ans = String.valueOf(no);

        // System.out.println(k0+" "+d+" "+pos+" "+digIndex+" "+base+" "+no+" "+ans);

        return ans.charAt((int)digIndex)-'0';
    }   
}