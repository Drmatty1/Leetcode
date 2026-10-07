class Solution {

    boolean check(String s){
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            }
            else if (ch == ')') {
                balance--;

                if (balance < 0)
                    return false;
            }
        }

        return balance == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        
        Queue<String> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        q.add(s);
        set.add(s);
        List<String> ans = new ArrayList<>();

        while(!q.isEmpty()){

            int size = q.size();
            boolean found = false;

            while(size-->0){

                String curr = q.poll();
                

                if(check(curr)){ 
                    ans.add(curr);
                    found = true;
                }

                if(found) continue;

                int len = curr.length();
                for(int i=0; i<len; i++){
                    char c = curr.charAt(i);
                    if( c!='(' && c!=')' || (i>0 && c == curr.charAt(i-1))) continue;

                    String next = curr.substring(0,i)+curr.substring(i+1);
                    if(set.contains(next)) continue;

                    set.add(next);
                    q.add(next);
                }

            }

            if(found) break;

        }

        return ans;

    }
}