class Solution {
   
    String []arr;
    
    StringBuilder sol(int x){
    
        if(x < 1) return new StringBuilder();
        
        StringBuilder ans = new StringBuilder();
        
        int exp = 31 - Integer.numberOfLeadingZeros(x);
        // System.out.println(exp+" "+x);
            
        if(exp > 25){
            ans.append("z"+sol(x-(1<<25)));
        }
        else{
            ans.append(arr[exp]+sol(x-(1<<exp)));
        }
        return ans;
    }
    public String[] largestString(int[] nums) {
 
        arr = new String[26];
        for(int i=0; i<26; i++){
            arr[i] = String.valueOf((char)(i+'a'));
        }

        int n = nums.length;
        String []ans = new String[n];
        for(int i=0; i<n; i+=1){
            ans[i] = sol(nums[i]).toString();
        }

        return ans;
    }
}
// 600
// 512->j + 88
// 64 - > g + 24
// 16 -> e + 8
// 8 -> d
// jged

// 7
// 4 -> c + 3
// 2 -> b + 1;
// 1 -> a;
