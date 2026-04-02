class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int []ast = asteroids;

        int n = ast.length;
        int blasted=0;

        Stack<Integer> st = new Stack<>();

        for( int i =0; i<n; i++ ){

            if(ast[i] < 0 ){

                if( !st.isEmpty() ){
                    int t = st.peek();
                    if( Math.abs(ast[i]) == Math.abs(ast[t]) ){
                        ast[i] = 0;
                        ast[t] = 0;
                        blasted += 2;
                        st.pop();
                    }
                    else if( Math.abs(ast[i]) > Math.abs(ast[t]) ){
                        ast[t] = 0;
                        blasted += 1;
                        st.pop();
                        i--;
                    }
                    else{
                        ast[i] = 0;
                        blasted += 1;
                    }
                }
            }
            else st.push(i);
        }

        int []res = new int[n-blasted];
        int k= 0;

        for( int e : ast ){
            if( e != 0 ){
                res[k++] = e ;
            }
        }
        return res;
    }
}