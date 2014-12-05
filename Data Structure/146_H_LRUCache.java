/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Hide Tags Data Structure

 * reference :
 * http://www.cnblogs.com/TenosDoIt/p/3417157.html
 * http://www.ninechapter.com/solutions/lru-cache/
 *
 * 这里需要实现get方法和set方法。
 * get为查询方法
 * set为插入或是更新方法。
 * 每次我们查询或是插入节点，我们都要把节点的位置放在tail。tail表示最近使用过的节点。head表示最新least used的节点。
 * 题目需要用一个Queue来实现每次的排序。cache为一个有限量的空间，保存了最近常用的数据。由此，我们用queue来实现。不常用的数据
 * 则从cache中剔除。常用的，要更新在cache中的位置。则需要一个queue，当每次用到信息，则把它放到尾，而不常用的信息则从头remove
 * 1. 当我们变换节点位置的时候，需要首先把它从queue中delete。这里为了更好实现queue，
 * 用到doubly LinkedList。通过已知的prev和next节点来remove此节点。
 * 2. 当用get方法时，由于LinkedList需要n的操作时间，这里用hashmap，把key和Node存入map中，只需要O(1)的时间
 *
 * doubly linkedlist要储存key和value
 * 是因为当需要remove map中的元素的时候，无法通过LinkedList的value来remove
 * public V remove(Object key)
 * 根据api，只有通过其key才能remove valued
 * /已知LinkedList，remove其在map中的位置。
 * 必须知道key
 * */
public class LRUCache {
    //tail stores recently inquired node. if a node recently inquired, move it to tail
    //head stores least used node. If cache reaches maximum storage, delete head node
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache(int capacity) {
         this.capacity = capacity;
         head.next = tail;
         tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        /**1. remove Node from Queue
         * 1-1 get the node from the hashmap
           1-2 remove the node from the queue, and put it to the tail**/
        Node current = map.get(key);
        //need to update position of both prev and next nodes
        current.prev.next = current.next;
        current.next.prev = current.prev;

        moveToTail(current);
        return map.get(key).value;
    }

    public void set(int key, int value) {
        //I. if has node IN THE CACHE, update value
        if (get(key) != -1){
            map.get(key).value = value;
            return;
        }
        /**II. IF NO NODE IN THE CACHE
         * if cache is over capacity
         * delete the least used node from map and head of the linkedlist.**/
        if (map.size() == capacity){
            //head and tail are dummy node
            //1.remove first not dummy head node from map
            map.remove(head.next.key);
            //2.remove the node from the queue
            head.next = head.next.next;
            head.next.prev = head;
        }
        /**
         * insert node to the tail,
         * and add the info to the map
         **/
         Node insert = new Node(key, value);
         map.put(key, insert);
         moveToTail(insert);

    }
    public void moveToTail(Node current){
        //tail is the dummy node
        Node prev = tail.prev;
        prev.next = current;
        current.prev = prev;
        current.next = tail;
        tail.prev = current;
        /**current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;**/
    }
}
