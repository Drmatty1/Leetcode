class Solution {
    Map<Integer,Integer> dp = new HashMap<>();
    public int reverseBits(int n) {
        if( dp.containsKey(n) ) return dp.get(n);
        StringBuilder ans = new StringBuilder();
        while( ans.length() < 32 ){
            int rem = n%2;
            ans.append((char)(rem+'0'));
            n = n/2;
        }
        int rev = Integer.parseInt(ans.toString(),2);
        dp.put(n, rev);
        return rev;
    }
}