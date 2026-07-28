class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;

        int mid =  n/2;
        StringBuilder ans = new StringBuilder();

        char []arr = s.substring(0,mid).toCharArray();
        Arrays.sort(arr);
        String left = new String(arr);
        
        StringBuilder right = new StringBuilder(left);
        right = right.reverse();
        
        ans.append(left);
        if(n%2 !=0) ans.append(s.charAt(mid));
        ans.append(right);

        return ans.toString();
    }
}