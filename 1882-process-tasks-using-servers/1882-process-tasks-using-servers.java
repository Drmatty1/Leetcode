class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<long[]> sv = new PriorityQueue<>(
            (a,b) -> {
                if(a[0] == b[0]) return Long.compare(a[1],b[1]);
                return Long.compare(a[0],b[0]);
            }
        );
        int m = tasks.length, n = servers.length;
        for(int i=0; i<n; i++){
            sv.add(new long[]{servers[i],i,0});
        }
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a,b) ->  Long.compare(a[2],b[2])
        );

        long time = -1;
        Queue<long[]> taskQ = new ArrayDeque<>();
        int []ans = new int[m];
        int k=0;
        for(int i=0; i<m; i++){
            time++;
            taskQ.add(new long[]{tasks[i],time});
            while(!busy.isEmpty() && busy.peek()[2] <= time){
                sv.add(busy.poll());
            }
            while(!taskQ.isEmpty() && !sv.isEmpty()){
                long []server = sv.poll();
                long []task = taskQ.poll();
                server[2] = time+tasks[(int)task[1]];
                busy.add(server);
                ans[k++] = (int)server[1];
            }
        }

        time++;
        while(!taskQ.isEmpty()){
            while(!busy.isEmpty() && busy.peek()[2] <= time){
                sv.add(busy.poll());
            }
            if(sv.isEmpty()){
                time = busy.peek()[2];
                while(!busy.isEmpty() && busy.peek()[2] <= time){
                    sv.add(busy.poll());
                }
            }

            while(!taskQ.isEmpty() && !sv.isEmpty()){
                long []server = sv.poll();
                long []task = taskQ.poll();
                server[2] = time+tasks[(int)task[1]];
                busy.add(server);
                ans[k++] = (int)server[1];
            }
        }

        return ans;
    }
}