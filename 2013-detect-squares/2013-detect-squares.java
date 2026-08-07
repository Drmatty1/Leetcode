class DetectSquares {
    Map<Integer,Integer> map;
    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int key = (point[0]<<12)|point[1];
        map.put(key,map.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        
        int ans = 0;
        int x = point[0], y = point[1];


        for(int l=1; x-l>=0 && y-l>=0; l++){
            int f1 = map.getOrDefault( ((x-l)<<12) |y ,0);
            int f2 = map.getOrDefault( (x<<12) |(y-l) ,0);
            int f3 = map.getOrDefault( ((x-l)<<12) |(y-l) ,0);

            ans += f1*f2*f3;
        }
        
        
        for(int l=1; x+l<=1000 && y+l<=1000; l++){
            int f1 = map.getOrDefault( ((x+l)<<12) | y ,0);
            int f2 = map.getOrDefault( (x<<12) | (y+l) ,0);
            int f3 = map.getOrDefault( ((x+l)<<12) | (y+l) ,0);

            ans += f1*f2*f3;
        }

        for(int l=1; x-l>=0 && y+l<=1000 ; l++){
            int f1 = map.getOrDefault( ((x-l)<<12) |y ,0);
            int f2 = map.getOrDefault( (x<<12) |(y+l) ,0);
            int f3 = map.getOrDefault( ((x-l)<<12) |(y+l) ,0);

            ans += f1*f2*f3;
        }

        for(int l=1; x+l<=1000 && y-l>=0 ; l++){
            int f1 = map.getOrDefault( ((x+l)<<12) |y ,0);
            int f2 = map.getOrDefault( (x<<12) |(y-l) ,0);
            int f3 = map.getOrDefault( ((x+l)<<12) |(y-l) ,0);

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