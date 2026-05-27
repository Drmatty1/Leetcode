class Solution {

    boolean sol(String s1, String s2, String s3, int i, int j, int k){

        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        if( i == n1 ) 
            return s2.substring(j).equals(s3.substring(k));
        if( j == n2) 
            return s1.substring(i).equals(s3.substring(k));

        char c1 = s1.charAt(i), c2 = s2.charAt(j), c3 = s3.charAt(k); 
        if( c1 != c3 ){
            if(c2 != c3)return false;
            return sol(s1,s2,s3,i,j+1,k+1);
        }
        else{
            if(c2 != c3)return sol(s1,s2,s3,i+1,j,k+1);;
            return sol(s1,s2,s3,i,j+1,k+1)||sol(s1,s2,s3,i+1,j,k+1);
        }

    }


    boolean sol1(String s1, String s2, String s3, int i, int j, int k, Boolean [][][]dp){

        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        if( i == n1 ) 
            return s2.substring(j).equals(s3.substring(k));
        if( j == n2) 
            return s1.substring(i).equals(s3.substring(k));

        if(dp[i][j][k] != null) return dp[i][j][k];

        char c1 = s1.charAt(i), c2 = s2.charAt(j), c3 = s3.charAt(k); 
        if( c1 != c3 ){
            if(c2 != c3)return dp[i][j][k] = false;
            return dp[i][j][k]= sol1(s1,s2,s3,i,j+1,k+1,dp);
        }
        else{
            if(c2 != c3)
                return dp[i][j][k]=sol1(s1,s2,s3,i+1,j,k+1,dp);;
            return dp[i][j][k] = sol1(s1,s2,s3,i,j+1,k+1,dp)||sol1(s1,s2,s3,i+1,j,k+1,dp);
        }

    }


    boolean sol11(String s1, String s2, String s3, int i, int j, Boolean [][]dp){

        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        if( i == n1 ) 
            return s2.substring(j).equals(s3.substring(i+j));
        if( j == n2) 
            return s1.substring(i).equals(s3.substring(i+j));

        if(dp[i][j] != null) return dp[i][j];

        char c1 = s1.charAt(i), c2 = s2.charAt(j), c3 = s3.charAt(i+j); 
        if( c1 != c3 ){
            if(c2 != c3)return dp[i][j] = false;
            return dp[i][j]= sol11(s1,s2,s3,i,j+1,dp);
        }
        else{
            if(c2 != c3)
                return dp[i][j]=sol11(s1,s2,s3,i+1,j,dp);;
            return dp[i][j] = sol11(s1,s2,s3,i,j+1,dp)||sol11(s1,s2,s3,i+1,j,dp);
        }

    }


    boolean sol21(String s1, String s2, String s3){

        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();

        Boolean [][]dp = new Boolean[n1+1][n2+1];
        for(int i=0; i<=n1; i++){
            dp[i][n2] = s1.substring(i).equals(s3.substring(i+n2));
        }
        for(int j=0; j<=n2; j++){
            dp[n1][j] = s2.substring(j).equals(s3.substring(n1+j));
        }

        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){

                char c1 = s1.charAt(i), c2 = s2.charAt(j), c3 = s3.charAt(i+j); 
                if( c1 != c3 ){
                    if(c2 != c3)  dp[i][j] = false;
                    else dp[i][j] = dp[i][j+1];
                }
                else{
                    if(c2 != c3) dp[i][j]=dp[i+1][j];
                    else dp[i][j] = dp[i][j+1]||dp[i+1][j];
                }

            }
        }

        return dp[0][0];

    }


    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2= s2.length(), n3= s3.length();
        if(n1+n2!= n3 )return false;

        // return sol(s1,s2,s3,0,0,0);

        // Boolean [][][]dp = new Boolean[n1][n2][n3];
        // return sol1(s1,s2,s3,0,0,0,dp);

        // Boolean [][]dp = new Boolean[n1][n2];
        // return sol11(s1,s2,s3,0,0,dp);

        return sol21(s1,s2,s3);
    }
}