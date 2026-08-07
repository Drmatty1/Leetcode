class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n= s2.length();
        if(n < m) return false ;

        int[] arr_s1 = new int[26];
        for( int i=0; i<m; i++ ){
            arr_s1[ s1.charAt(i)-'a' ] ++;
        }

        int i=0, j=0 ;
        int countRequired = m;

        while( j < n ){

            int curr = s2.charAt(j)-'a';

            if(arr_s1[curr] > 0){
                countRequired--;
            }
            arr_s1[curr]--;
            // System.out.println(curr+" "+i+" "+j+" "+countRequired);

            if(j-i >= m){
                int prev = s2.charAt(i)-'a';
                if(arr_s1[prev] >= 0){
                    countRequired++;
                }
                arr_s1[prev]++;
                i++;
            }

            j++;
            if(countRequired == 0) return true;
        }

        return false;

    }
}