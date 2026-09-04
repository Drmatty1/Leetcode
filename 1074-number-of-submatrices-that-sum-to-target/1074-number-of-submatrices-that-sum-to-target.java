class Solution {
    int subarraySum(int []a, int t){
        int n = a.length;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int currSum= 0 ;
        int ans = 0;

        for(int i=0 ;i<n; i++){
            currSum += a[i];
            ans += map.getOrDefault(currSum-t,0);
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }

        return ans;

    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int r = matrix.length, c = matrix[0].length;

        int ans =0;

        for(int i=r-1; i>=0; i--){

            ans += subarraySum(matrix[i],target);
            
            for(int j=i-1; j>=0; j--){
                for(int k=0; k<c; k++){
                    matrix[i][k] += matrix[j][k];
                }
                ans += subarraySum(matrix[i],target);
        
            }
        }

        return ans;
    }
}
