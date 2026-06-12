class Solution {
    double gain(int []a){
        double res = (1D*a[0]+1)/(a[1]+1) - (1D*a[0])/(a[1]);
        return res;
    }
    public Double maxAverageRatio(int[][] classes, int extraStudents){
       //Write Your Code Here...
       int n = classes.length;
       PriorityQueue<int[]> pq = new PriorityQueue<>(
           (b,a)->{
               return Double.compare(gain(a),gain(b));
           }
         );
       for(int []e: classes) pq.add(e);
       
       while(extraStudents-->0){
           int[] t = pq.poll();
           t[0] ++;
           t[1] ++;
           pq.add(t);
       }
      
        double ans = 0;
       while(!pq.isEmpty()){
           int []t = pq.poll();
           ans += 1D*t[0]/t[1];
       }
       ans = ans/n;
       return ans;
   }
}