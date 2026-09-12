class Solution {
    Map<String,Box> dp;
    Map<String,Integer> index;
    class Box{
        long w;
        List<Integer> l;
        Box(){
            l = new ArrayList<>();
        }
        Box(Box a){
            this.w = a.w;
            this.l = new ArrayList<>(a.l);
        }
    };
    int bs(List<List<Integer>> arr, int t){
        int i=0, j=arr.size();

        while(i<j){
            int mid = (j+i)/2;
            if(arr.get(mid).get(0) >= t){
                j = mid;
            }
            else i = mid+1;
        }

        return i;
    }
    int compare(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }

    Box sol(int i, int k, List<List<Integer>> arr){

        if(i==arr.size() || k <= 0 ) return new Box();

        String key = i+"-"+k;
        if(dp.containsKey(key)) return dp.get(key);

        //skip
        Box skip = sol(i+1,k, arr);

        //take
        int j = bs(arr, arr.get(i).get(1)+1);
        // if(arr.get(j).get(0) <= arr.get(i).get(1) ) return skip;
        Box take = new Box(sol(j,k-1, arr));
        take.w += arr.get(i).get(2);
        take.l.add(index.get(
            arr.get(i).get(0)+"-"+arr.get(i).get(1)+"-"+arr.get(i).get(2)
        ));
        Collections.sort(take.l);

        Box ans ;
        if(skip.w > take.w) ans = skip;
        else if(skip.w < take.w) ans = take;
        //tie
        else if(compare(skip.l,take.l) <= 0) ans = skip;
        else ans = take;

        dp.put(key,ans);
        return ans;
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        dp = new HashMap<>();
        index = new HashMap<>();
    
        int i=0;
        for( List<Integer> a: intervals){
            index.putIfAbsent(a.get(0)+"-"+a.get(1)+"-"+a.get(2),i++);
        }

        Collections.sort(intervals, (a,b) -> a.get(0)-b.get(0));

        List<Integer> l = sol(0,4,intervals).l;
        int []ans = new int[l.size()];
        i=0;
        for(int e: l){
            ans[i++]=e;
        }
        return ans;
    }
}