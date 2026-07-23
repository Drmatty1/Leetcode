class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int e: nums) set.add(e);

        boolean []xorOf2 = new boolean[2048];
        for(int a: nums) 
            for(int b: nums) 
                xorOf2[a^b]=true;

        boolean []xorOf3 = new boolean[2048];

        for(int e: nums){
            for(int i=0; i<2048; i++){
                boolean c = xorOf2[i];
                if(c==true){
                    xorOf3[i^e] = true;
                }
            }
        }

        int count =  0;
        for(boolean c: xorOf3) if(c) count++;

        return count;

    }
}