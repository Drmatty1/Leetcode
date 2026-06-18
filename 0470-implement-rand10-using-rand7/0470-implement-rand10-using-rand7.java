/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        // while(true){
        //     int a = (rand7()-1)*7 + rand7() ;
        //     if( a <= 40 ) return (a%10)+1;
        // }
        int a = rand7();
        while(a == 7 ) a = rand7();
        if( a <= 3 ){
            int b = rand7();
            while( b>5 ) b = rand7();
            return b;
        }
        else{
            int b = rand7();
            while( b>5 ) b = rand7();
            return b+5;
        }

    }
}