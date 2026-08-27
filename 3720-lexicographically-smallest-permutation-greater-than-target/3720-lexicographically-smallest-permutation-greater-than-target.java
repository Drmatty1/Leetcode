class Solution {
    public String lexGreaterPermutation(String s, String target) {
        
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int matchedLen = 0;
        while (matchedLen < n && count[target.charAt(matchedLen) - 'a'] > 0) {
            count[target.charAt(matchedLen) - 'a']--;
            matchedLen++;
        }

        for (int k = matchedLen; k >= 0; k--) {
            if (k < n) {
                int targetCharIdx = target.charAt(k) - 'a';
                for (int c = targetCharIdx + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        count[c]--;
                        StringBuilder sb = new StringBuilder();
                        sb.append(target, 0, k);
                        sb.append((char) ('a' + c));
                        
                        for (int i = 0; i < 26; i++) {
                            while (count[i] > 0) {
                                sb.append((char) ('a' + i));
                                count[i]--;
                            }
                        }
                        return sb.toString();
                    }
                }
            }
            

            if (k > 0) {
                count[target.charAt(k - 1) - 'a']++;
            }
        }

        return "";
    }
}