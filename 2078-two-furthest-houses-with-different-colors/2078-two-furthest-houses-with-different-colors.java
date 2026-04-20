class Solution {
    public int maxDistance(int[] colors) {
        Map<Integer,int[]> map= new HashMap<>();
        for( int i=0; i<colors.length; i++ ){
            int key=colors[i];
            if(!map.containsKey(key)){
                map.put(key,new int[]{-1,-1});
            }
            int[] a= map.get(key);
            if(a[0] == -1){
                a[0]=i;
            }
            
            a[1]=i;
            
        }
        int ans=0;
        for( int i=0; i<colors.length; i++ ){
            for(var e: map.entrySet()){

                // System.out.println(i+" "+e.getKey());
                
                if(e.getKey()==colors[i])continue;
                int []t = e.getValue();
                System.out.println(i+" "+e.getKey()+" "+t[0]+" "+t[1]);
                int temp = Math.max(Math.abs(i-t[0]),Math.abs(i-t[1]));
                ans=Math.max(ans,temp);
            }
        }
        return ans;
    }
} 