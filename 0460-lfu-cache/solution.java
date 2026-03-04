class LFUCache {
    
    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyNode;
    private Map<Integer, DoublyLinkedList> freqList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyNode.containsKey(key)) return -1;

        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (keyNode.size() == capacity) {
            DoublyLinkedList minList = freqList.get(minFreq);
            Node toRemove = minList.removeLast();
            keyNode.remove(toRemove.key);
        }

        Node newNode = new Node(key, value);
        keyNode.put(key, newNode);
        freqList.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        minFreq = 1;
    }

     private void updateFreq(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqList.get(freq);
        list.removeNode(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqList.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }
}

class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                removeNode(last);
                return last;
            }
            return null;
        }
    }
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
