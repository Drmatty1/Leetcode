class Solution {
    List<String> maxNonOverlapInt(List<int[]> intervals, String s){

        intervals.sort(Comparator.comparingInt(a -> a[1]));

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return result;
    }
    public List<String> maxNumOfSubstrings(String s) {

        char []arr = s.toCharArray();
        int n = arr.length;

        int [] freq = new int[128];
        int [] first = new int[128];
        int [] last = new int[128];
        Arrays.fill(first,n+1);

        for(int i=0; i<n; i++){
            int c = arr[i];
            first[c] = Math.min(first[c],i);
            last[c] = Math.max(last[c],i);
            freq[c] ++;
        }

        List<int[]> iv = new ArrayList<>();

        for(char c='a'; c<='z'; c++){

            if(freq[c] == 0) continue;

            int i = first[c];
            int r = last[c];
            boolean valid = true;

            int j=i;
            while(j<=r){
                int curr = arr[j];
                if(first[curr] < i){
                    valid = false;
                    break;
                }
                r = Math.max(last[curr],r);
                j++;
            }

            if(valid){
                iv.add(new int[]{i,r});
            }
        }

        return maxNonOverlapInt(iv, s);
    }
}