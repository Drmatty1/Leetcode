class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int l = nums[0].length();
        char []ans = new char[l];
        int i=0;
        for( String s : nums ){
            char c = s.charAt(i);
            ans[i] = c=='1'?'0':'1';
            i++;
        }
        return new String(ans);
    }
}