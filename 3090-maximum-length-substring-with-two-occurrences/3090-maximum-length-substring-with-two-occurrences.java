class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int i=0, j=0, n = s.length();
        int ans=0;
        int maxfreq = 0;
        int invalidCt = 0;
        while(j<n){
            char curr = s.charAt(j);
            mp.put(curr,mp.getOrDefault(curr,0)+1);

            if(mp.get(curr) == 3) invalidCt++;

            while(invalidCt != 0){
                char prev = s.charAt(i);
                if(mp.get(prev)==3) invalidCt--;
                mp.put(prev,mp.get(prev)-1);
                if(mp.get(prev)==0) mp.remove(prev);
                i++;
            }
            ans = Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}