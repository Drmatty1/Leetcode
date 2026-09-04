class Solution {
    Map<Integer,Integer> map = new HashMap<>();

    int subarraySum(int []a, int t ){
        int n = a.length;

        map.clear();
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
    int sol1(int[][] matrix, int target) {
        
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

    int sol2(int[][] matrix, int target) {  
        int r = matrix.length, c = matrix[0].length;

        int[][] pre = new int[r][c + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                pre[i][j + 1] = pre[i][j] + matrix[i][j];
            }
        }

        int ans = 0;

        for(int c1 = 0; c1<c; c1++){
            for(int c2 = c1; c2<c; c2++){
                
                int runningSum = 0;
                map.clear();
                map.put(0,1);

                for(int i=0; i<r; i++){
                    runningSum += pre[i][c2+1]-pre[i][c1];
                    ans += map.getOrDefault(runningSum-target,0);
                    map.put(runningSum,map.getOrDefault(runningSum,0)+1);
                }

            }
        }

        return ans;
        
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {  
        // return sol1(matrix, target);
        return sol2(matrix, target);
        
    }
}
