class Solution {
    public boolean sumGame(String num) {
        int left_sum = 0, right_sum =0;
        int leftQ = 0, rightQ =0;

        int i=0, j =num.length()-1;
        while(i<j){

            if(num.charAt(i) != '?'){
                left_sum += num.charAt(i)-'0';
            }
            else leftQ++;

            if(num.charAt(j) != '?'){
                right_sum += num.charAt(j)-'0';
            }
            else rightQ++;

            i++;
            j--;
        }

        int sumDiff = Math.abs(left_sum-right_sum);

        if( (leftQ+rightQ)%2 != 0) return true;

        if(leftQ == rightQ) return sumDiff!=0;
        // System.out.println("ji");
        if(left_sum > right_sum && leftQ >= rightQ )  return true;
        // System.out.println("ji");
        if(left_sum < right_sum && leftQ <= rightQ )  return true;
        // System.out.println("ji");

        int qDiff = Math.abs(leftQ-rightQ);

        if( sumDiff%9 ==0 && (2*sumDiff)/qDiff==9) return false;
        // System.out.println("ji"+(sumDiff)+" "+qDiff);
        return true; 

    }
}