class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for( int i=0; i<n.length(); i++ ){
            int c = n.charAt(i)-'0';
            max = Math.max(max,c);
            if( max == 9 ) return 9;
        }
        return max;
    }
}