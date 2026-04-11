class Solution {
    static List<Integer> p = new ArrayList<>();
    static void Sieve(){
        int M=100004;
        boolean []nonPrime = new boolean[M];
        nonPrime[1] = true;
        nonPrime[2] = false;
        nonPrime[3] = false;
        for( int i=2; i*i<M; i++ ){
            if( nonPrime[i]==false ){
                for(int j=i*i; j<M; j+=i){
                    nonPrime[j] = true;
                }
            }
        }

        for( int i=2; i<M; i++ ){
            boolean b = nonPrime[i];
            if(b==false) p.add(i);
        }

    }

    int BS(int t){
        int s=0, e = p.size()-1 ;
        int mid=0;

        while(s<=e){
            mid = (e-s)/2+s;
            if( p.get(mid) == t ){
                return mid;
            }
            else if( p.get(mid) < t ){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return -(s+1);
    }

    public int minOperations(int[] nums) {
        
        if(p.size() == 0) Sieve();
        int l = nums.length;

        int ans = 0;

        for( int i=0; i<l; i+=2 ){
            int t = nums[i];
            int idx = BS(t);
            if( idx < 0 ) ans += p.get(-idx-1)-t;
        }

        for( int i=1; i<l; i+=2 ){
            int t = nums[i];
            int idx = BS(t);
            if( idx >= 0 ){
                if( t == 2 ) ans+=2;
                else ans+=1;
            }
        }
        return ans;
    }
}
















