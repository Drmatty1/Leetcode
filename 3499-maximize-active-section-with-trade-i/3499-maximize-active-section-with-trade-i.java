class Solution {
    int sol(String s) {
        StringBuilder temp = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int max = 0;
        int total = 0;
        
        for(int i=0; i<s.length(); i++){
            int l = temp.length();
            if( l == 0 || temp.charAt(l-1)==s.charAt(i) ){
                temp.append(s.charAt(i));
            }
            else {
                ans.add(new String(temp));
                if(temp.charAt(0) == '1')  total += temp.length();

                temp = new StringBuilder();
                temp.append(s.charAt(i));
            }
        }

       if(temp.charAt(0) == '1')   total += temp.length();
       ans.add(new String(temp));

        // for(String str: ans) System.out.println(str);

       
        for(int i=1; i<ans.size()-1; i++){
            boolean currOne = ans.get(i).charAt(0) == '1';
            boolean left0 = ans.get(i-1).charAt(0) == '0';
            boolean right0 = ans.get(i+1).charAt(0) == '0';

            if( currOne && left0 && right0 ){

                int len = ans.get(i-1).length()+ans.get(i+1).length();
                max = Math.max(max, len);
            }
        }

        // System.out.println(max+" "+total);
        return max+total;

    }
    int sol1(String s){

        int n = s.length();
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
        }

        List<Integer> zeroBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            if (s.charAt(start) == '0') {
                zeroBlocks.add(i - start);
            }
        }

        int m = zeroBlocks.size();
        if (m < 2) {
            return cnt1;
        }
        int bestGain = 0; // Optimal Increment
        for (int j = 0; j < m - 1; j++) {
            bestGain = Math.max(
                bestGain,
                zeroBlocks.get(j) + zeroBlocks.get(j + 1)
            );
        }

        return cnt1 + bestGain;
    }

    public int maxActiveSectionsAfterTrade(String s) {
        return sol1(s);
    }
}