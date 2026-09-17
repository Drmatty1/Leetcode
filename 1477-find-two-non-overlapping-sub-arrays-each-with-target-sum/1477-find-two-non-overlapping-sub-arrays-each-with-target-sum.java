class Solution {
    int n;
    List<int[]> iv;
    int bs(int start){
        int i=0,j=iv.size();
        while(i<j){
            int mid = (j+i)/2;
            if(iv.get(mid)[0] >= start ){
                j = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }
    // O(nlogn)
    int solNoob(int[] arr, int target) {
        n = arr.length;
        iv = new ArrayList<>();

        int i=0, j=0;
        int sum =0;
        while(j<n){

            sum += arr[j];

            while(sum>target){
                sum -= arr[i];
                i++;
            }

            if(sum==target){
                iv.add(new int[]{i,j});
            }

            j++;
        }

        List<int[]> sortedI = new ArrayList<>(iv);

        // print(iv);

        Collections.sort(sortedI, (a,b)->a[1]-b[1]);
        Collections.sort(iv, (a,b)->a[0]-b[0]);

        // print(iv);
        // print(sortedI);

        i=0;
        j=0;

        int l = iv.size();
        if(l<2)  return -1;

        int []suff = new int[l+1];
        suff[l] = 100000;
        for(int t=l-1; t>=0; t--){
            suff[t] = Math.min(suff[t+1], iv.get(t)[1] - iv.get(t)[0]+1 );
        }

        // print1(suff);

        int ans = n+1;
        for(int k=0; k<l; k++){
            int []currI = sortedI.get(k);
            int len1 = currI[1]-currI[0]+1;
            int end = currI[1];
            int nextIdx = bs(end+1);

            // System.out.println(len1+" "+end+" "+nextIdx);
            ans = Math.min(ans, len1+suff[nextIdx]);
            // System.out.println(ans+" "+(len1+suff[nextIdx]));
        }

        return ans==(n+1)?-1:ans;

    }

    int solOP(int[] arr, int target) {
        int n = arr.length;

        // best[i] = minimum length of a valid subarray
        // completely inside arr[0 ... i-1]
        int INF = 1_000_000_000;
        int[] best = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Since all elements are positive,
            // shrink the window while sum is too large.
            while (sum > target) {
                sum -= arr[left++];
            }

            // We found a subarray [left ... right] with sum = target
            if (sum == target) {
                int len = right - left + 1;

                // best[left] contains the shortest valid subarray
                // completely before this one.
                if (best[left] != INF) {
                    ans = Math.min(ans, len + best[left]);
                }

                // Update the best answer up to right.
                best[right + 1] = Math.min(best[right], len);
            } else {
                // No new valid subarray ending at right.
                best[right + 1] = best[right];
            }
        }

        return ans == INF ? -1 : ans;
    }

    public int minSumOfLengths(int[] arr, int target) {
        return solOP(arr,target);
    }
}
