class Solution {
    public double angleClock(int hour, int minutes) {
        double minNed = 1L*minutes/5.0;
        double hourNed = hour + (minNed/12.0);
        double diff = Math.abs(hourNed-minNed);

        if(diff > 6.0) diff = 12.0 - diff;

        return 360*diff/12;
    }
}
// l = r*theta   ; 12 = r*360;
// r = 12/360;
// l*360/12;