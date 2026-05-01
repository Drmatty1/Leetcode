class LRUCache {
    Map<Integer,Integer> lru;
    int size;
    public LRUCache(int capacity) {
        lru = new LinkedHashMap<>(capacity,0.8f,true);
        size = capacity;
    }
    
    public int get(int key) {
        return lru.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        lru.put(key,value);
        if(lru.size()>size){
            lru.remove(lru.keySet().iterator().next());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */