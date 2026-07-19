class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int one = 0, zero = 0;
        char []arr = s.toCharArray();
        int n = arr.length;;

        for(char c: arr){
            if(c=='1') one++;
            else zero++;
        }

        int[] posA = new int[zero];
        int idxA = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                posA[idxA++] = i;
            }
        }


        int len = strs.length;
        boolean []ans = new boolean[len];

        for(int i=0; i<len; i++){
            char []curr = strs[i].toCharArray();

            int o = 0, z = 0;
            for(char c: curr){
                if(c=='1') o++;
                else if(c=='0') z++;
            }

            if(o > one || z > zero){
                ans[i] = false;
                continue;
            }

            int neededZeros = zero - z;
            int[] posB = new int[zero];
            int idxB = 0;
           
           for (int j = 0; j < n; j++) {

                char c = curr[j];

                if (c == '0') {
                    posB[idxB++] = j;
                } else if (c == '?') {
                    if (neededZeros > 0) {
                        posB[idxB++] = j;
                        neededZeros--;
                    }
                }
            }

            boolean possible = true;
            for (int j = 0; j < zero; j++) {
                if (posB[j] > posA[j]) {
                    possible = false;
                    break;
                }
            }
            
            ans[i] = possible;
            
        }

        return ans;
        
    }
}







