class MyHashMap {

   int size =(int) Math.pow(10, 4);
   Node[] arr;
   class Node {
    int key;
    int val;
    Node next;
    public Node(int key , int val){
        this.key = key;
        this. val = val;
    }
    
   }
    
    public MyHashMap() {
        arr = new Node[size];
    }

    public int getIndex(int key){
        return Math.abs(key) % this.size;
    }
    public void put(int key, int value) {
        int idx = getIndex(key);
        if(arr[idx] == null){
            arr[idx] = new Node(key, value);
            return ;
        }

        Node curr = arr[idx];
        while(curr != null){
            if(curr.key == key){
                curr.val = value;
                return ;
            }if(curr.next == null){
                break;
            }
            curr  = curr.next;
        }
        curr.next = new Node(key, value);
        
    }
    
    public int get(int key) {
        int idx = getIndex(key);
        Node curr = arr[idx];
        while(curr!= null){
            if(curr.key == key){
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = getIndex(key);
        Node curr = arr[idx];
        Node prev = null;
        while(curr != null){
            if(curr.key == key){
                if(prev == null) arr[idx] = curr.next;
                else prev.next = curr.next;
            }
        prev = curr;
        curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */