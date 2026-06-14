class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for(int i=0; i<n; i++){

            Map<Integer,Integer> freq = new HashMap<>();
            TreeMap<Integer,Integer> count = new TreeMap<>();

            for(int j=i; j<n; j++){
                int key = nums[j];
                freq.put(key,freq.getOrDefault(key,0)+1);

                int f = freq.get(key);
                if( f > 1 ){
                    int pf = count.get(f-1);  // prevFreq
                    count.put(f-1, pf-1);
                    if( pf-1 == 0 ) count.remove(f-1);
                }

                count.put(f, count.getOrDefault(f,0)+1);
                
                if(count.size() == 2 && 
                    count.firstKey()*2 == count.lastKey()){
                    
                    ans = Math.max(ans, j-i+1);
                }
                else if( freq.size() == 1 ) ans = Math.max(ans, j-i+1);

            }
        }

        return ans;
    }
}