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
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */