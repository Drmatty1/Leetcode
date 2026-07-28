class RandomizedSet {
    int n ;
    List<Integer> arr ;
    Map <Integer,Integer> map ;

    public RandomizedSet() {
        n = 0;
        arr = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;

        map.put(val,n);

        if( arr.size() == n )  arr.add(val);
        else arr.set(n,val);
        n++;

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int idx = map.get(val);
        int last = n-1;

        if(idx == last) {
            n--;
            map.remove(val);
            return true;
        }

        arr.set(idx,arr.get(last));
        n--;
        map.remove(val);

        map.put(arr.get(last), idx);

        return true;
    }
    
    public int getRandom() {

        int res = (int)(Math.random()*n);
        
        return arr.get(res);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */