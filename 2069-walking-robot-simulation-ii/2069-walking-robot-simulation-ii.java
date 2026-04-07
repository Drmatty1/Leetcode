class Robot {

    int step = 0;
    int x =0 , y = 0;
    int width , height ,peri;
    int d=0;
    int [][]dir = {{1,0},{0,1},{-1,0},{0,-1}};
    String []s = { "East", "North", "West", "South" };

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        d = 0;
        peri = width*2 + 2*(height-2);
    }
    
    public void step(int num) {
        step += num;
        if( step%peri == 0 ){
            if(x==0&&y==0) d=3;
        }
        step = step % peri;
        
    }
    
    public int[] getPos() {

        if( step == 0 ) return new int[]{x,y};

        while( step != 0 ){

        
            int[] vals = {width - x - 1, height - y - 1, x, y};
            int rem = vals[d];

            int min = Math.min(rem,step);
            x += min*dir[d][0];
            y += min*dir[d][1];

            if( step > rem ){
                step -= rem;
                d = (d+1)%4;
            }
            else step = 0;

        }

        return new int[]{x,y};

    }
    
    public String getDir() {
        if( step == 0 ) return s[d];

        getPos();
        return s[d];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */