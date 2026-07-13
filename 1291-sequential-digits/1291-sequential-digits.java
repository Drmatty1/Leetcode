class Solution {
    int dc(int e){
        return String.valueOf(e).length();
    }
    public List<Integer> sequentialDigits(int low, int high) {

        int ld = dc(low), hd = dc(high);
        List<Integer> ans=  new ArrayList<>();

        String all = "123456789";
        for(int d = ld; d<=hd; d++){
            int i=0, j=d;
            while(j<10){
                int temp = Integer.parseInt(all.substring(i++,j++));
                if( temp < low || temp > high ) continue;
                ans.add(temp);
            }
        }
        return ans;
    }
}