class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int am1 = Integer.parseInt(arriveAlice.substring(0,2));
        int ad1 = Integer.parseInt(arriveAlice.substring(3,5));
        int lm1 = Integer.parseInt(leaveAlice.substring(0,2));
        int ld1 = Integer.parseInt(leaveAlice.substring(3,5));

        int am2 = Integer.parseInt(arriveBob.substring(0,2));
        int ad2 = Integer.parseInt(arriveBob.substring(3,5));
        int lm2 = Integer.parseInt(leaveBob.substring(0,2));
        int ld2 = Integer.parseInt(leaveBob.substring(3,5));


        int []md = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int []pre = new int[13];
        for(int i=1; i<12; i++){
            pre[i] = pre[i-1]+md[i-1];
        }

        int a = pre[am1-1]+ ad1;
        int b = pre[lm1-1]+ ld1;

        int c = pre[am2-1]+ ad2;
        int d = pre[lm2-1]+ ld2;

        int days = Math.min(b,d) - Math.max(a,c)+1;
        
        if(days < 0) return 0;
        return days;

    }
}