class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> sv = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0])
                    return Integer.compare(a[1], b[1]);

                return Integer.compare(a[0], b[0]);
            }
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int n = servers.length;
        int m = tasks.length;

        for (int i = 0; i < n; i++) {
            sv.add(new int[]{servers[i], i});
        }

        Queue<Integer> taskQ = new ArrayDeque<>();

        int[] ans = new int[m];
        long time = 0;

        // Process incoming tasks
        for (int i = 0; i < m; i++) {

            time = i;
            taskQ.add(i);

            // Release completed servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();

                sv.add(new int[]{
                    (int)s[1],
                    (int)s[2]
                });
            }

            // Assign waiting tasks
            while (!taskQ.isEmpty() && !sv.isEmpty()) {

                int[] server = sv.poll();
                int task = taskQ.poll();

                ans[task] = server[1];

                busy.add(new long[]{
                    time + tasks[task],
                    server[0],
                    server[1]
                });
            }
        }

        // Process remaining waiting tasks
        time = m;

        while (!taskQ.isEmpty()) {

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();

                sv.add(new int[]{
                    (int)s[1],
                    (int)s[2]
                });
            }

            if (sv.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();

                    sv.add(new int[]{
                        (int)s[1],
                        (int)s[2]
                    });
                }
            }

            while (!taskQ.isEmpty() && !sv.isEmpty()) {

                int[] server = sv.poll();
                int task = taskQ.poll();

                ans[task] = server[1];

                busy.add(new long[]{
                    time + tasks[task],
                    server[0],
                    server[1]
                });
            }
        }

        return ans;
    }
}