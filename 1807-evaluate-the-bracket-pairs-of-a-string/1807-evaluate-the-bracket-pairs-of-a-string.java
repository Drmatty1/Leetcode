class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> l: knowledge){
            map.put(l.get(0),l.get(1));
        }

        int i=0, n = s.length();
        StringBuilder ans = new StringBuilder();
        while(i<n){
            if(s.charAt(i) == '('){
                int j = i+1;
                while(j<n && s.charAt(j) != ')') j++;
                String key = s.substring(i+1,j);
                ans.append(map.getOrDefault(key, "?"));
                i = j+1;
            }
            else{
                ans.append(s.charAt(i));
                i++;
            }
        }
        return new String(ans);
    }
}