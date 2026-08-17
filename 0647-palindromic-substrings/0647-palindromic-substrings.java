class Solution {
    int count(char []a, int i, int j){
        if(i<0 || j>= a.length) return 0;
        int n = a.length;

        int count = 0;
        while(i>=0 && j<n){
            if(a[i--] == a[j++]) count++;
            else break;
        }
        return count;
    }
    public int countSubstrings(String s) {
        char []a = s.toCharArray();
        int n = a.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += count(a,i,i+1); //even length;
            ans += 1+count(a,i-1,i+1); //odd length;
        }
        return ans;
    }
}