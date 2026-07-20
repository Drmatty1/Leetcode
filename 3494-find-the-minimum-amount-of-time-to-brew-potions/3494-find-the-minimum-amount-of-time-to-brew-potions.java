class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m=mana.length;
        long []arr = new long[n];

        long []pre = new long[n];
        pre[0] = skill[0];
        for(int i=1; i<n; i++){
            pre[i] = pre[i-1]+skill[i];
        }
        
        for(int i=0; i<n; i++){
            arr[i] = pre[i]*mana[0];
        }

        for(int i=1; i<m; i++){

            long x = 0;
            x = arr[0];
            for(int j=0; j<n-1; j++){
                long minTime = arr[j+1] - pre[j]*mana[i];
                x = Math.max(x,minTime);
            }

    
            for(int j=0; j<n; j++){
                arr[j] = x+pre[j]*mana[i];
            }

        }

        return arr[n-1];

    }
}
/**

    x is min start timr for next row

        0      5            30        40          60
        x>=5   x+1>=30      x+6>=40   x+8>=60     x+12
    x:   5      29           34        52

 */