class Solution {
    boolean canJump( int[] s, int m ){
        int prev = s[0], n = s.length;
        boolean []flag = new boolean[n];

        for( int i=1; i<n; i++ ){

            if( i+1 < n && s[i+1]-prev <= m ) continue;

            if( s[i]-prev > m ) return false;

            flag[i] = true;
            prev = s[i];
        }

        flag[n-1] = false;
        flag[0] = false;

        List<Integer> arr = new ArrayList<>();

        for( int i=0; i<n; i++ ){
            if( flag[i] == false )arr.add(s[i]);
        }

        int l = arr.size();
        prev = arr.get(0);
        
        for( int i =1; i<l; i++ ){

            if( i+1 < l && arr.get(i+1)-prev <= m ) continue;

            if( arr.get(i)-prev > m ) return false;

            prev = arr.get(i);

        }
        return true;
    }
    boolean canJump1( int[] s, int m ){

        int prev = s[0], n = s.length;
        boolean []flag = new boolean[n];

        for( int i=1; i<n; i++ ){

            if( s[i]-prev <= m ) continue;

            // must have jumped here
            flag[i-1] = true;
            prev = s[i-1];
            
            if( s[i]-prev > m ) return false;
        }

        prev = s[n-1];
        
        for( int i =n-2; i>=0; i-- ){

            if( flag[i] == true ) continue;

            if( prev-s[i] > m ) return false;
            
            prev = s[i];

        }
        return true;
    }
    int BSOnRange(int[] stones){
        int []s = stones;
        int l = 1, h = s[s.length-1];
        int potentialAns = h;

        while( l <= h ){
            int mid = (h-l)/2+l;
            if( canJump1(s,mid) ){
                potentialAns = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return potentialAns;
    }
    public int maxJump(int[] stones) {
        int n = stones.length;
        int res = stones[1]-stones[0];
        for( int i=2; i<n; i++ ){
            res = Math.max(res,stones[i]-stones[i-2]);
        }
        return res;
    }
}