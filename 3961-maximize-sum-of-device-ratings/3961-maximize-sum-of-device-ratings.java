class Solution {
    public long maxRatings(int[][] units) {
        int n = units.length, m = units[0].length;
        for(int []a: units) Arrays.sort(a);
        Arrays.sort(units, (a,b)->Integer.compare(a[0],b[0]));

        long ans = 0;
        int j = (m==1?0:1);
        int min = 100000;
        int min1 = 100000;
        for(int []a: units){
            ans += a[j];
            min = Math.min(min,a[j]);
            min1 = Math.min(min1, a[0]);
        }

        return ans-min+min1;
    }
}