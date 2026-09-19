class Solution {
    double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        double diag = dist(x1,y1,x2,y2)/2;
        double xmid = (1D*x1+x2)/2, ymid = (1D*y1+y2)/2;
        double sideX = (1D*x2-x1)/2;
        double sideY = (1D*y2-y1)/2;
        
        if(dist(xCenter,yCenter,xmid,ymid) > radius+diag ) return false;

        if( yCenter <= y2 && yCenter >= y1 && dist(xCenter,yCenter,xmid,ymid) <= radius+sideX ) return true;
        if( xCenter <= x2 && xCenter >= x1 && dist(xCenter,yCenter,xmid,ymid) <= radius+sideY ) return true;

        if( yCenter <= y2 && yCenter >= y1 ){
            if( Math.abs(xCenter-xmid) <= radius + sideX ) return true;
        }
        if( xCenter <= x2 && xCenter >= x1 ){
            if( Math.abs(yCenter-ymid) <= radius + sideY ) return true;
        }
        if( yCenter >= y2 ){
            if(xCenter <= xmid){
                if( dist(xCenter,yCenter,x1,y2) <= radius ) return true;
            }
            else{
                if( dist(xCenter,yCenter,x2,y2) <= radius ) return true;
            }
        }
        if( yCenter <= y1 ){
             if(xCenter <= xmid){
                if( dist(xCenter,yCenter,x1,y1) <= radius ) return true;
             }
            else{
                if( dist(xCenter,yCenter,x2,y1) <= radius ) return true;
            }
        }
        
        return false;
    }
}