class Solution {
    int maxNonOverlapping(List<int[]> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = -1;

        for (int i = 0; i < intervals.size(); i++) {
            int[] current = intervals.get(i);
            if (current[0] > lastEnd) {
                count++;
                lastEnd = current[1];
            }
        }

        return count;
    }
    public int maxPalindromes(String s, int k) {
        
        char []c = s.toCharArray();
        int n = c.length;
        List<int[]> interval = new ArrayList<>();

        for(int i=0; i<n; i++){
            
            int len = 1;
            int l=i-1, r=i+1;
            for(; l>=0 && r<n && len < k; l--,r++){
                if(c[l] == c[r]) len += 2;
                else break;
            }

            // System.out.println(i+" "+len+" "+l+" "+r);
            if(len >= k) interval.add(new int[]{i-len/2,i+len/2});


            len = 0;
            l=i;
            r=i+1;
            for(; l>=0 && r<n && len < k; l--,r++){
                if(c[l] == c[r]) len += 2;
                else break;
            }

            // System.out.println(i+" "+len+" "+l+" "+r+" ---");
            if(len >= k) interval.add(new int[]{i-len/2+1,i+len/2});

        }

        // for(int []a: interval){
        //     System.out.println(a[0]+" "+a[1]);
        // }

        return maxNonOverlapping(interval);
    }
}