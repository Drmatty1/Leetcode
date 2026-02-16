class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int time=0;
        for( int []e : courses ){
    
            int dur = e[0];
            int last = e[1];

            pq.add(dur);
            time+=dur;

            if( time > last ){
                time += -pq.poll();
            }
        }
        return pq.size();
    }
}