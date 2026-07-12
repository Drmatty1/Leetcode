class Solution {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int []temp = new int[n];
        for(int i=0; i<n; i++) temp[i] = arr[i];
        Arrays.sort(temp);

        Map<Integer,Integer> map = new HashMap<>();
        if( n > 0)  map.put(temp[0],1);
        int rank = 2;
        for(int i=1; i<n; i++){
            if(temp[i] != temp[i-1]) map.put(temp[i],rank++);
        }

        int []ans = new int[n];
        for(int i=0; i<n; i++){
            int idx = map.get(arr[i]);
            ans[i] = idx;
        }
        return ans;
    }
}