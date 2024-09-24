package com.company.linklist;

import java.util.HashMap;
import java.util.Map;

//This class implements the cache of key value pair where key is a number and value is a word.
//At max cache can have CACHE_LIMIT number of entries
public class LRUCache {
    private static final int CACHE_LIMIT = 3;
    HashMap<Integer, NodeDoublyLL> map = new HashMap<Integer, NodeDoublyLL>();
    DoublyLL list = new DoublyLL();
    int currentSize = 0;

    int get(int key) {
        if (map.containsKey(key)) {
            return  map.get(key).data;
        }
        return -1;
    }

    void set(int key, int value) {
        // Make sure map to be updated wherever list node is added/deleted
        //If map contains the key then bring that node to the front
        // Else check for cache limit.
            //If limit is full then remove the tail and add new node in front
            //Else add new node in front.
        if(map.containsKey(key)) {
            NodeDoublyLL currentNode = map.get(key);
            map.remove(key);
            addInFront(currentNode);
        } else {
            NodeDoublyLL currentNode = new NodeDoublyLL(value);
            if (currentSize < CACHE_LIMIT) {
                addInFront(currentNode);
                currentSize++;
            } else {
                map.remove(getKeyFromMap(list.tail.data));
                removeTail();
                addInFront(currentNode);
            }
            map.put(key, currentNode);
        }
    }

    private int getKeyFromMap(int value){
        for(Map.Entry<Integer,NodeDoublyLL> entry:map.entrySet()) {
            if(entry.getValue().data== value) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private void addInFront(NodeDoublyLL node) {
        if (list.head == null) {
            list.head = node;
            list.tail = node;
        } else {
            node.next= list.head;;
            list.head.prev = node;
            list.head = node;
        }
    }

    private  void removeTail() {
        list.tail = list.tail.prev;
        list.tail.next = null;
    }

}
