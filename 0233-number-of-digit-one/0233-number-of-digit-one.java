class Solution {
    String s;
    int sol(int pos, int tight, int count1){
        if(pos == s.length() )return count1;

        char curr = s.charAt(pos);
        int limit = tight==1?(curr-'0'):9;

        int ans=0;

        for(int d=0; d<=limit; d++){
            int newtight = (tight==1 && d==limit)?1:0;
            
            int newCount = count1 + (d==1?1:0);

            ans += sol(pos+1, newtight, newCount);
        }
        return ans;
    }

    int sol1(int pos, int tight, int count1, Map<String,Integer> dp){
        if(pos == s.length() )return count1;

        char curr = s.charAt(pos);
        int limit = tight==1?(curr-'0'):9;

        String key = pos+" "+tight+" "+count1;
        if(dp.containsKey(key))return dp.get(key);

        int ans=0;

        for(int d=0; d<=limit; d++){
            int newtight = (tight==1 && d==limit)?1:0;
            
            int newCount = count1 + (d==1?1:0);

            ans += sol1(pos+1, newtight, newCount, dp);
        }

        dp.put(key,ans);
        return ans;
    }

    public int countDigitOne(int n) {
        s = String.valueOf(n);
        Map<String,Integer> dp = new HashMap<>();
        // return sol(0,1,0);
        return sol1(0,1,0,dp);
    }
}