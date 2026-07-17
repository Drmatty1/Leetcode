class Solution {
    int len(int e){
        int ans= 0;
        while(e>0){
            ans += 1;
            e /= 10;
        }
        return ans;
    }
    public int compress(char[] chars) {
        int n = chars.length;
        int ans = 0;
        int count = 1;
        StringBuilder s = new StringBuilder();

        for(int i=1; i<chars.length; i++){
            if(chars[i] == chars[i-1]){
                count ++ ;
            }
            else{
                if(count == 1){
                    ans += 1;
                    s.append(chars[i-1]);
                }
                else{
                    ans += 1 + len(count);
                    s.append(chars[i-1]);
                    s.append(String.valueOf(count));
                    count = 1;
                }
            }
        }

       if(count == 1){
            ans += 1;
            s.append(chars[n-1]);
        }
        else{
            ans += 1 + len(count);
            s.append(chars[n-1]);
            s.append(String.valueOf(count));
            count = 1;
        }
        
        int len = s.length();
        for(int k=0; k<len; k++) chars[k] = s.charAt(k);

        System.out.println(s);
        return ans;
    }
}