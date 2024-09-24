package com.company.trees;

/**
 * MaxHeap is a complete binary tree in which each node is greater than it's children.
 * Mapping the elements of a heap into an array is trivial. If a node is stored in index k,
 *      then it's left child is stored in position 2*k + 1 and
 *      it's right child is stored in position 2*k + 2 and
 * Height of MaxHeap tree is log n where n is the total number of elements in the tree
 * Number of nodes in each level of tree goes like: 1, 2, 4, 8, 16, 32, ...
 * Bottom most level of the tree contains 1 + count of all the nodes of rest of the levels
 * Parent nodes in a heap tree is n/2 where n is the number array size.
 * For heapify the whole array, heapfying all parent nodes is good enough. And parent nodes are from 0...n/2 in the array.
 */
public class MaxHeap {
    int[] heap;
    int size;
    int maxSize;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
    }

    int parentPos(int pos) {
        return (pos -1)/2;
    }

    int leftChildPos(int pos) {
        return (2*pos) + 1;
    }

    int rightChildPos(int pos) {
        return (2*pos) + 2;
    }

    /**
     * Start with the element sent as argument.
     * Compare if that is the bigger than left and right child.
     *      If yes, all done
     *      Otherwise, swap it with the bigger child
     *  Repeat above steps till current index is smaller than size/2. After size/2 current index is point to a leaf node.
     */
    void heapify(int startElement) {
        int currentIndex = startElement;
        while (currentIndex<size/2) {
            int leftChildIndex = leftChildPos(currentIndex);
            int rightChildIndex = rightChildPos(currentIndex);

            if (heap[currentIndex] < heap[leftChildIndex] || heap[currentIndex] < heap[rightChildIndex]) {
                if(heap[leftChildIndex]> heap[rightChildIndex]) {
                    swapArrayElements(currentIndex, leftChildIndex);
                    currentIndex = leftChildIndex;
                } else {
                    swapArrayElements(currentIndex, rightChildIndex);
                    currentIndex = rightChildIndex;
                }
            } else {
                break;
            }
        }
    }

    int getMaxElement() {
        return heap[0];
    }

    int getMinElement() {
        return heap[size];
    }

    /**
     * Remove first element.
     * Put last element in first position
     * Heapify the tree with starting element as 0.
     */
    int removeMaxElement(){
        int maxElement = getMaxElement();
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return maxElement;
    }

    /**
     * Insert element in the end
     * Compare it the last element with parent.
     *      If smaller, all good
     *      Otherwise, swap it with parent.
     * Repeat till the children position is greater than 0.
     */
    void insertElement(int element) {
        int childPos = size;
        int parentPos = parentPos(size);
        heap[size++] = element;
        while (childPos>0) {
            if (heap[parentPos] < heap[childPos]) {
                swapArrayElements(parentPos, childPos);
                childPos = parentPos;
                parentPos = parentPos(childPos);
            } else {
                break;
            }
        }
    }

    void swapArrayElements(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    void printMaxHeapByLevel() {
        int level = 0;
        int arrayCounter = 0;
        while (arrayCounter < size) {
            int nodesCountInLevel = (int) Math.pow(2, level);
            int levelCounter = 0;
            while (arrayCounter < size && levelCounter < nodesCountInLevel) {
                System.out.print(heap[arrayCounter] + " ");
                arrayCounter++;
                levelCounter++;
            }
            System.out.println();
            level++;
        }
    }

    public static void mainFn() {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insertElement(5);
        maxHeap.insertElement(3);
        maxHeap.insertElement(17);
        maxHeap.insertElement(10);
        maxHeap.insertElement(84);
        maxHeap.insertElement(19);
        maxHeap.insertElement(6);
        maxHeap.insertElement(22);
        maxHeap.insertElement(9);
        maxHeap.printMaxHeapByLevel();
        System.out.println("Testing element removal");
        maxHeap.removeMaxElement();
        maxHeap.printMaxHeapByLevel();
    }
}
