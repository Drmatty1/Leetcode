class Solution {
    public int minMoves(String[] classroom, int energy) {

        int r = classroom.length, c = classroom[0].length();

        int [][]id = new int[r][c];
        for(int i=0; i<r; i++) Arrays.fill(id[i],-1);

        int k = 0;
        int x=-1,y=-1;
        int i = 0, j = 0;
        for(String s: classroom){
            j = 0;
            for(char ch: s.toCharArray()){
                if(ch=='L'){ 
                    id[i][j] = k++;
                }
                if(ch == 'S'){
                    x = i;
                    y = j;
                }
                j++;
            }
            i++;
        }

        if(k==0) return 0;
        
        int total_mask = (1<<k)-1;

        int [][][]maxEnergy = new int[r][c][total_mask+1];
        for ( i = 0; i < r; i++) {
            for ( j = 0; j < c; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        maxEnergy[x][y][0] = energy;

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{x,y,0,energy});

        int [][]dirs = { {0,1}, {0,-1}, {1,0}, {-1,0} };
        int moves = 0;

        while(!q.isEmpty()){
            
            int size = q.size();
            moves++;

            for(int s=0; s<size; s++){

                int []curr = q.poll();
                
                for(int []d: dirs){

                    int nx = curr[0] + d[0];
                    int ny = curr[1] + d[1];
                    int nmask = curr[2];
                    int ne = curr[3] - 1;

                    if( nx < 0 || nx>=r || ny<0 || ny>=c) 
                        continue;
                    
                    if( classroom[nx].charAt(ny) == 'X' )
                        continue;


                    if( classroom[nx].charAt(ny) == 'L' ){
                        nmask |= (1<<id[nx][ny]) ;
                    }

                    if(nmask == total_mask) return moves;

                    if( classroom[nx].charAt(ny) == 'R' )   
                        ne = energy;
                    
                    if(ne == 0) continue;

                    if( ne <= maxEnergy[nx][ny][nmask] ) continue;

                    maxEnergy[nx][ny][nmask] = ne;

                    q.add(new int[]{nx,ny,nmask,ne});
                }
            }
        }

        return -1;

    }
}