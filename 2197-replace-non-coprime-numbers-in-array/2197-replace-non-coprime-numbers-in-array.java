class Solution {
    int hcf(int a, int b){
        if(b==0)return a;
        return hcf(b,a%b);
    }
    long lcm(int a, int b){
        return 1L*a*b/hcf(a,b);
    }
    boolean ncprm(int a, int b){
        return hcf(a,b)>1;
    }

    List<Integer> sol(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int e: nums){
            int fusion  = e;
            while( !st.isEmpty() && ncprm(fusion,st.peek()) ){
                fusion = (int)lcm(fusion,st.pop());
            }
            st.add(fusion);
        }
        return new ArrayList<>(st);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int []st = new int[nums.length+1];
        int top = -1;

        for(int e: nums){
            int fusion  = e;
            while( (top!=-1) ){
                int hcf = hcf(fusion,st[top]);
                if(hcf <= 1 ) break;
                fusion = (int)(1L*fusion*st[top--]/hcf);
            }
            st[++top] = fusion ;
        }
        List<Integer> res = new ArrayList<>();
        for(int k=0; k<=top; k++)res.add(st[k]);

        return res;
    }
}