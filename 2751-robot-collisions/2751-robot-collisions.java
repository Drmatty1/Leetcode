class Solution {

    List<Integer> sol1(int[] positions, int[] healths, String directions) {
        List<Integer> res = new ArrayList<>();
        int n = positions.length;
        int [][]ans = new int[n][3];
        for( int i =0; i<n; i++ ){
            ans[i][0] = positions[i];
            ans[i][1] = healths[i];
            ans[i][2] = directions.charAt(i)=='L'?0:1;
        }
        Arrays.sort(ans,(a,b)->Integer.compare(a[0],b[0]));
        Stack<Integer> st = new Stack<>();
        for( int i =0; i<n; i++ ){
            if(ans[i][2] == 0 ){
                if( !st.isEmpty() ){
                    int t = st.peek();
                    if( ans[i][1] == ans[t][1] ){
                        ans[i][1] = 0;
                        ans[t][1] = 0;
                        st.pop();
                    }
                    else if( ans[i][1] > ans[t][1] ){
                        ans[t][1] = 0;
                        ans[i][1] -= 1;
                        st.pop();
                        i--;
                    }
                    else if( ans[i][1] < ans[t][1] ){
                        ans[t][1] -= 1;
                        ans[i][1] = 0;
                    }
                }
            }
            else st.push(i);
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        for( int i=0; i<n; i++ ) map.put(positions[i],i);
        for( int i=0; i<n; i++ ){
            int t = map.get(ans[i][0]);
            positions[t] = ans[i][1];
        }

        for( int e : positions ){
            if( e != 0 ){
                res.add(e);
            }
        }
        return res;
    }

    List<Integer> sol2(int[] positions, int[] healths, String directions) {
         List<Integer> res = new ArrayList<>();
        int n = positions.length;
        int [][]ans = new int[n][4];
        for( int i =0; i<n; i++ ){
            ans[i][0] = positions[i];
            ans[i][1] = healths[i];
            ans[i][2] = directions.charAt(i)=='L'?0:1;
            ans[i][3] = i;
        }
        Arrays.sort(ans,(a,b)->Integer.compare(a[0],b[0]));
        Stack<Integer> st = new Stack<>();
        for( int i =0; i<n; i++ ){
            if(ans[i][2] == 0 ){
                if( !st.isEmpty() ){
                    int t = st.peek();
                    if( ans[i][1] == ans[t][1] ){
                        ans[i][1] = 0;
                        ans[t][1] = 0;
                        st.pop();
                    }
                    else if( ans[i][1] > ans[t][1] ){
                        ans[t][1] = 0;
                        ans[i][1] -= 1;
                        st.pop();
                        i--;
                    }
                    else if( ans[i][1] < ans[t][1] ){
                        ans[t][1] -= 1;
                        ans[i][1] = 0;
                    }
                }
            }
            else st.push(i);
        }
        
        Arrays.sort(ans,(a,b)->Integer.compare(a[3],b[3]));

        for( int []e : ans ){
            if( e[1] != 0 ){
                res.add(e[1]);
            }
        }
        return res;
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        return sol2(positions,healths,directions);
    }
}