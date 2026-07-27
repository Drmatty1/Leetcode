class Solution {
    int ev(int x, int y, char op){
        switch (op){
            case '+': return x+y;
            case '-': return x-y;
            case '*': return x*y;
        }
        return 0;
    }
    List<Integer> sol(String ex, int s, int e) {
        // if(s>=e) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for( int i=s; i<=e; i++){
            char c = ex.charAt(i);
            if(!Character.isDigit(c)){
                List<Integer> l = sol(ex, s, i-1 );
                List<Integer> r = sol(ex, i+1, e );

                for(int a: l){
                    for(int b: r){
                        res.add(ev(a,b,c));
                    }
                }
            }
        }

        // If res is empty, no operators were found in this range.
        // It means the string from index s to e is a pure number (e.g. "5" or "12").
        if (res.isEmpty()) {
            res.add(Integer.parseInt(ex.substring(s, e + 1)));
        }

        return res;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return sol(expression,0,expression.length()-1);
    }
}