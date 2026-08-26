class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        char []arr = s.toCharArray();

        String ans = "";
        int i=0,j=0;
        int count = 0;

        while(j<n){
            
            count += arr[j]-'0';
            j++;
            
            while( count == k ) {
                System.out.println(ans+" "+i+" "+j+" "+count);
                if(ans.equals("") || ans.length() > (j-i) )
                    ans = s.substring(i,j);
                else if(ans.length() == (j-i)){
                    int cmp = ans.compareTo(s.substring(i,j));
                    if(cmp > 0) ans = s.substring(i,j);
                }
                count -= arr[i]-'0';
                i++;
            }
        }

        return ans;
    }
}














