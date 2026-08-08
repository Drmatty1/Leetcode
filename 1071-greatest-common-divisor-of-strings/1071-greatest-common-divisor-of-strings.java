class Solution {
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    boolean divides(String s, String t){
        int n =  s.length();
        int l = t.length();
        if(n%l != 0) return false;

        for(int i=0; i<n; i+=l ){
            for(int j=i; j<i+l; j++){
                if(t.charAt(j-i) != s.charAt(j)) return false;
            }
        }

        return true;
    }
    public String gcdOfStrings(String str1, String str2) {

        int n1 =  str1.length(), n2 = str2.length();
        if(n1 == n2){
            if(str1.equals(str2)) return str1;
            return "";
        }

        int gcd = gcd(n1,n2);
        String res = str1.substring(0,gcd);
        if( divides(str1,res) && divides(str2,res) ) return res;

        // for(int i=0; i<Math.abs(n1-n2) ; i++){
        //     int l = res.length();
        //     if( divides(str1,res) && divides(str2,res) ) 
        //         return res;
        //     res = res+res;
        //     if(res.length() >= Math.min)
        // }

        return "";
    }
}