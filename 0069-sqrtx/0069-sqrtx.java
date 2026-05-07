class Solution {
    public int mySqrt(int x) {
        int a = x;
        double y = 1;
        double epsilon = 0.0000001;
        for(int i=0; ; i++){
            double ny = (y*y+a)/(2*y);
            if( Math.abs(ny-y) <= epsilon ){
                y = ny;
                System.out.println(ny+" "+y+" "+(int)y);
                break;
            }
            System.out.println(ny+" "+y+" "+(int)y);
            y = ny;
        }
        return (int)(y);
    }
}