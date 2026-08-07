class DetectSquares {
    // Map<Integer,Integer> map;
    int [][]map ;
    public DetectSquares() {
        // map = new HashMap<>();
        map = new int[1001][1001];
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];

        // int key = (x<<12)|y;
        // map.put(key,map.getOrDefault(key,0)+1);

        map[x][y] ++;
    }

    
    public int count(int[] point) {
        
        int ans = 0;
        int x = point[0], y = point[1];


        for(int l=1; x-l>=0 && y-l>=0; l++){
            int f1 = map[x-l][y];
            int f2 = map[x][y-l];
            int f3 = map[x-l][y-l];

            ans += f1*f2*f3;
        }
        
        
        for(int l=1; x+l<=1000 && y+l<=1000; l++){
            int f1 = map[x+l][y];
            int f2 = map[x][y+l];
            int f3 = map[x+l][y+l];

            ans += f1*f2*f3;
        }

        for(int l=1; x-l>=0 && y+l<=1000 ; l++){
            int f1 = map[x-l][y];
            int f2 = map[x][y+l];
            int f3 = map[x-l][y+l];

            ans += f1*f2*f3;
        }

        for(int l=1; x+l<=1000 && y-l>=0 ; l++){
            int f1 = map[x+l][y];
            int f2 = map[x][y-l];
            int f3 = map[x+l][y-l];

            ans += f1*f2*f3;
        }

        return ans;

    }
}

/**
import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    // Outer key: X-coordinate, Inner key: Y-coordinate, Inner value: Frequency of point (X, Y)
    private Map<Integer, Map<Integer, Integer>> pointCounts;

    public DetectSquares() {
        pointCounts = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        
        // If the X-coordinate doesn't exist, initialize a new inner map
        pointCounts.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yCounts = pointCounts.get(x);
        
        // Increment the occurrence of this specific (X, Y) point
        yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;
        
        // If no points share the same X-coordinate, no squares can be formed
        if (!pointCounts.containsKey(x1)) {
            return 0;
        }
        
        // Find all stored points sharing the same X-coordinate
        Map<Integer, Integer> sameXPoints = pointCounts.get(x1);
        
        for (int y2 : sameXPoints.keySet()) {
            // Skip if it's the exact same coordinate (square must have a positive area)
            if (y2 == y1) {
                continue;
            }
            
            // Side length of the potential square
            int side = Math.abs(y1 - y2);
            int countP2 = sameXPoints.get(y2);
            
            // Case 1: The square expands to the right (x3 = x1 + side)
            int x3Right = x1 + side;
            if (pointCounts.containsKey(x3Right)) {
                Map<Integer, Integer> rightXPoints = pointCounts.get(x3Right);
                int countP3 = rightXPoints.getOrDefault(y1, 0);
                int countP4 = rightXPoints.getOrDefault(y2, 0);
                totalSquares += countP2 * countP3 * countP4;
            }
            
            // Case 2: The square expands to the left (x3 = x1 - side)
            int x3Left = x1 - side;
            if (pointCounts.containsKey(x3Left)) {
                Map<Integer, Integer> leftXPoints = pointCounts.get(x3Left);
                int countP3 = leftXPoints.getOrDefault(y1, 0);
                int countP4 = leftXPoints.getOrDefault(y2, 0);
                totalSquares += countP2 * countP3 * countP4;
            }
        }
        
        return totalSquares;
    }
}
 */

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */