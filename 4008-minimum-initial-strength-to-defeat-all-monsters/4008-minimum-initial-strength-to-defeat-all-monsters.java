class Solution {


    boolean canDefeat(long initialStrength, int[] monsters, long[] bonus) {
        long curr = initialStrength;
        for (int i = 0; i < monsters.length; i++) {
            // Cannot defeat monster
            if (curr + bonus[i] < monsters[i]) {
                return false;
            }
            // Strength decreases, clamped at 0
            curr = Math.max(0L, curr - monsters[i]);
        }
        return true;
    }
    long sol1(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n + 1];

        // 1. Build standard difference array (left to right)
        for (int[] b : boosts) {
            int l = b[0], r = b[1], v = b[2];
            diff[l] += v;
            diff[r + 1] -= v;
        }

        // 2. Precompute prefix sum for bonus at each index
        long[] bonus = new long[n];
        long currentBonus = 0;
        for (int i = 0; i < n; i++) {
            currentBonus += diff[i];
            bonus[i] = currentBonus;
        }

        // 3. Binary Search on the initial strength
        long low = 0;
        long high = 0;
        for (int m : monsters) {
            high += m;
        }

        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canDefeat(mid, monsters, bonus)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid strength
            } else {
                low = mid + 1;  // Need more strength
            }
        }

        return ans;
    }


    long sol_OP(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long []diff = new long[n];
        for(int []b: boosts){
            int l=b[0], r=b[1], v=b[2];
            diff[r]+=v;
            if(l-1>=0) diff[l-1]-=v;
        }

        long needLater = 0, bonus=0;

        for(int i=n-1; i>=0; i--){

            bonus += diff[i];

            if(needLater > 0) needLater += monsters[i];
            else{
                needLater = Math.max(0,monsters[i]-bonus);
            }
        }

        return needLater;
    }

    public long minInitialStrength(int[] monsters, int[][] boosts) {
        return sol1(monsters,boosts);
    }
}