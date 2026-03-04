class LRUCache {
    HashMap<Integer,Node> map ;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        DeleteNode(node);
        InsertNode(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            DeleteNode(node);
            InsertNode(node);
        }
        else{
            if(map.size() == capacity) {
                Node node = tail.prev;
                map.remove(node.key);
                DeleteNode(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            InsertNode(node);
        }
    }

    public void InsertNode(Node node){
        Node after = head.next;
        head.next = node;
        node.next = after;
        after.prev = node;
        node.prev = head;
    }

    public void DeleteNode(Node node){
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;
        node.next = null;
        node.prev = null;
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key,int value){
        this.key = key;
        this.value = value; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
