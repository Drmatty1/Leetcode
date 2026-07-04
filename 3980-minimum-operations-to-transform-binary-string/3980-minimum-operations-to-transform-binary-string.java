class Solution {
    public int minOperations(String s1, String s2) {
        int i=0,j = 0;
        int n = s1.length();
        char []a1 = s1.toCharArray();
        char []a2 = s2.toCharArray();
        int ans = 0;
        while(i<n){
            if( a1[i] == a2[j] ) {
                i++;
                j++;
            }
            else if( a1[i] == '0' ){
                i++;
                j++;
                ans++;
            }
            else{
                if( i == n-1 ){
                    if( i == 0 ) return -1;
                    ans += 2;
                    i++;
                    j++;
                }
                else{
                    if( a1[i+1] == '0' ){
                        ans += 2;
                        i++;
                        j++;
                    }
                    else {
                        ans +=1;
                        a1[i+1] = '0';
                        i++;
                        j++;
                    }
                }
            }
        }
        return ans;
    }
}