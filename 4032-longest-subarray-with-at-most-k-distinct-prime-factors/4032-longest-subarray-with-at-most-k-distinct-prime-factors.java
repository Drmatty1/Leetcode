class Solution {

    public int longestSubarray(int[] nums, int k) {

        int maxValue = 100000;
        int[] smallestPrime = new int[maxValue + 1];
        for(int i=2; i<=maxValue; i++){
            for(int j=i; j<=maxValue; j+=i){
                if(smallestPrime[j] == 0){
                    smallestPrime[j] = i;
                }
            }
        }

        int[][] factors = new int[nums.length][];
        for(int i=0; i<nums.length; i++){

            int x = nums[i];
            int count = 0;
            int temp = x;

            while(temp>1){
                int p = smallestPrime[temp];
                count ++;

                while(temp%p == 0) temp /= p;
            }

            factors[i] = new int[count];

            temp = x;

            int idx = 0;

            while(temp>1){
                int p = smallestPrime[temp];
                factors[i][idx++] = p;

                while(temp%p == 0) temp /= p;
            }

        }

        int []frequency = new int[maxValue+1];

        int left = 0;
        int distinct = 0;
        int answer = 0;

        for(int right = 0; right<nums.length; right++){

            for(int p: factors[right]){
                if(frequency[p] == 0){
                    distinct++;
                }
                frequency[p]++;
            }

            while( distinct > k ){

                for(int p: factors[left++]){
                    frequency[p]--;

                    if(frequency[p] == 0){
                        distinct--;
                    }
                }

            }

            answer = Math.max(answer, right-left+1);
        }

        return answer;

    }
}