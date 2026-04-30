class Solution {
    int f(int []a, int i){
        int n = a.length;
        int s = i;

        if( a[s] < 0 || s == (s+a[s])%n ) return 0;
        s = (s+a[s])%n;

        Set<Integer> set = new HashSet<>();
        set.add(i);

        while(!set.contains(s)){
            if( a[s] < 0 || s == (s+a[s])%n) return 0;
            set.add(s);
            s = (s+a[s])%n; 
        }
        return 1;

    }
    int b(int []a, int i){
        int n = a.length;
        int s = i;

        int k = Math.abs(a[s])%n;
        if( a[s] > 0 || s == (s+n-k)%n ) return 0;
        s = (s+n-k)%n;

        Set<Integer> set = new HashSet<>();
        set.add(i);

        while(!set.contains(s)){
            if( a[s] > 0 || s == (s+n+a[s])%n) return 0;
            set.add(s);
            k = Math.abs(a[s])%n;
            s = (s+n-k)%n; 
        }
        return 1;

    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]>0 && f(nums,i)==1)return true;
            if(nums[i]<0 && b(nums,i)==1)return true;
        }
        return false;
    }
}