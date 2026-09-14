class Solution {
    int area(int ax1, int ay1, int ax2, int ay2) {
        return (ax2-ax1)*(ay2-ay1);
    }
    int overlapArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int minax = Math.max(ax1,bx1);
        int minay = Math.max(ay1,by1);
        int minbx = Math.min(ax2,bx2);
        int minby = Math.min(ay2,by2);
        if( (minbx-minax)<0 || (minby-minay)<0 ) return 0;
        return (minbx-minax)*(minby-minay);
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return area(ax1,ay1,ax2,ay2)+
                area(bx1,by1,bx2,by2) -
                 overlapArea(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2);
    }
}