class Solution {
    int sol11(int[] aliceValues, int[] bobValues) {
        int[] freq = new int[201];
        for (int i = 0; i < aliceValues.length; i++)
            freq[aliceValues[i] + bobValues[i]]++;

        int diff = -Arrays.stream(bobValues).sum();
        int pos = 0;
        for (int v = 200; v > 1; v--) {
            int c = freq[v];
            if (c > 0) {
                diff += v * (pos % 2 == 0 ? (c + 1) / 2 : c / 2);
                pos += c;
            }
        }

        return Integer.signum(diff);
    }
    int sol12(int[] aliceValues, int[] bobValues) {
        List<Integer>[] count = new ArrayList[201];

        for (int i = 0; i < count.length; i++) {
            count[i] = new ArrayList<>();
        }

        for (int i = 0; i < aliceValues.length; i++) {
            count[aliceValues[i] + bobValues[i]].add(i);
        }

        int aliceSum = 0;
        int bobSum = 0;
        boolean isAlice = true;

        for (int i = 200; i >= 0; i--) {
            for (int index : count[i]) {
                if (isAlice) {
                    aliceSum += aliceValues[index];
                } else {
                    bobSum += bobValues[index];
                }

                isAlice = !isAlice;
            }
        }

        if (aliceSum > bobSum) {
            return 1;
        } else if (aliceSum < bobSum) {
            return -1;
        }

        return 0;
    }
    // there is one more soln - sorting based
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        return sol11(aliceValues,bobValues);
    }
}