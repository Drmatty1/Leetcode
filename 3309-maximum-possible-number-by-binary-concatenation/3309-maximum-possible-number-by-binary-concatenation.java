class Solution {
    static int numberOfBits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }
    static boolean compare(int a, int b){
        int m = numberOfBits(a), n = numberOfBits(b);
        return Integer.compare( (a<<n)|b, (b<<m)|a )==1;
    }
    public int maxGoodNumber(int[] nums) {
        int a=0, b=0, c=0;

        if( compare(nums[0],nums[1])  ){

            if( compare(nums[0],nums[2] ) ){
                a = nums[0];
                if( compare(nums[1],nums[2]) ){
                    b = nums[1];
                    c = nums[2];
                }
                else{
                    c = nums[1];
                    b = nums[2];
                }
            }
            else{
                a = nums[2];
                if( compare(nums[0],nums[1]) ){
                    b = nums[0];
                    c = nums[1];
                }
                else{
                    b = nums[1];
                    c = nums[0];
                }
            }
        }
        else{   
            if( compare(nums[1],nums[2] ) ){
                a = nums[1];
                if( compare(nums[0],nums[2]) ){
                    b = nums[0];
                    c = nums[2];
                }
                else{
                    c = nums[0];
                    b = nums[2];
                }
            }
            else{
                a = nums[2];
                if( compare(nums[1],nums[0]) ){
                    b = nums[1];
                    c = nums[0];
                }
                else{
                    b = nums[0];
                    c = nums[1];
                }
            }
        }
        // System.out.println(a+" "+b+" "+c);
        int lb = numberOfBits(b), lc = numberOfBits(c);
        return (a<<(lb+lc)) | (b<<lc) | c;
    }
}