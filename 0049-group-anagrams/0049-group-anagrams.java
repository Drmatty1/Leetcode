class Solution {
    StringBuilder sort(String s){
        int []arr = new int[26];
        for(char c : s.toCharArray())  arr[c - 'a']++;
        StringBuilder res = new StringBuilder();
        for( int i=0; i<26; i++ ){
            while(arr[i]>0){
                res.append((char)(i+'a'));
                arr[i]--;
            }
        }
        return res;

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans= new ArrayList<>();
        Arrays.sort(strs, (a,b) -> { 
            return sort(a).compareTo(sort(b));
        });
        
        int l = strs.length;
        List<String> temp =  new ArrayList<>();
        temp.add(strs[0]);

        for( int i=1; i<l; i++ ){

            if( sort(strs[i]).compareTo(sort(strs[i-1]))==0 ){
                temp.add(strs[i]);
            }
            else{
                ans.add(new ArrayList<>(temp));
                // temp = new ArrayList<>();
                temp.clear();
                temp.add(strs[i]);
            }
        }
        ans.add(temp);
        return ans;
    }
}