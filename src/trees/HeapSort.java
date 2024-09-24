package com.company.trees;

/**
 * Heap sort:
 * 1. Do MaxHeapify for all the parent nodes which are present in first n/2 elements
 * 2. Pick top element one by one from Max Heap and do
 *      a. Fill array from right to left
 *      b. Heapify the tree excluding the elements processed from maxHeap
 */

public class HeapSort {
    int parentPos(int pos) {
        return (pos -1)/2;
    }

    int leftChildPos(int pos) {
        return (2*pos) + 1;
    }

    int rightChildPos(int pos) {
        return (2*pos) + 2;
    }



    int getMaxElement(int[] arr) {
        return arr[0];
    }

    int getMinElement(int[] arr) {
        return arr[arr.length-1];
    }


    void swapArrayElements(int pos1, int pos2, int[] arr) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    void printMaxHeapByLevel(int[] arr) {
        int level = 0;
        int arrayCounter = 0;
        while (arrayCounter < arr.length) {
            int nodesCountInLevel = (int) Math.pow(2, level);
            int levelCounter = 0;
            while (arrayCounter < arr.length && levelCounter < nodesCountInLevel) {
                System.out.print(arr[arrayCounter] + " ");
                arrayCounter++;
                levelCounter++;
            }
            System.out.println();
            level++;
        }
    }

    void heapifyMaxArrElementRecursive(int[] array, int currentElement, int size) {
        if(currentElement>= size/2) {
            return;
        }
        int leftChildPos = leftChildPos(currentElement);
        int rightChildPos = rightChildPos(currentElement);
        if (leftChildPos < size && rightChildPos < size) {
            if (array[currentElement] < array[leftChildPos] || array[currentElement] < array[rightChildPos]) {
                if (array[leftChildPos] > array[rightChildPos]) {
                    swapArrayElements(currentElement, leftChildPos, array);
                    heapifyMaxArrElementRecursive(array, leftChildPos, size);
                } else {
                    swapArrayElements(currentElement, rightChildPos, array);
                    heapifyMaxArrElementRecursive(array, rightChildPos, size);
                }
            }
        } else if (leftChildPos < size) {
            if (array[currentElement] < array[leftChildPos]) {
                swapArrayElements(currentElement, leftChildPos, array);
                heapifyMaxArrElementRecursive(array, rightChildPos, size);
            }
        }
    }

    void heapifyMaxArrElementIterative(int[] array, int currentElement, int size) {
        int leftChildPos = leftChildPos(currentElement);
        int rightChildPos = rightChildPos(currentElement);
        while (currentElement< size/2) {
            if (leftChildPos <= (size - 1) && rightChildPos <= (size - 1)) {
                if (array[currentElement] < array[leftChildPos] || array[currentElement] < array[rightChildPos]) {
                    if (array[leftChildPos] > array[rightChildPos]) {
                        swapArrayElements(currentElement, leftChildPos, array);
                        currentElement = leftChildPos;
                        leftChildPos = leftChildPos(currentElement);
                        rightChildPos = rightChildPos(currentElement);
                    } else {
                        swapArrayElements(currentElement, rightChildPos, array);
                        currentElement = rightChildPos;
                        leftChildPos = leftChildPos(currentElement);
                        rightChildPos = rightChildPos(currentElement);
                    }
                }
            } else if (leftChildPos <= (size - 1)) {
                if (array[currentElement] < array[leftChildPos]) {
                    swapArrayElements(currentElement, leftChildPos, array);
                    leftChildPos = leftChildPos(currentElement);
                    rightChildPos = rightChildPos(currentElement);
                }
            } else {
                break;
            }
        }
    }

    void heapifyMaxCompleteArray(int[] array) {
        for (int i = array.length/2 -1; i>=0; i--) {
            //heapifyMaxArrElementIterative(array, i);
            heapifyMaxArrElementRecursive(array, i, array.length);
        }
    }

    void sortMaxHeap(int[] array) {
        for (int i=0; i<array.length;i++) {
            swapArrayElements(0, array.length-1-i, array);
            heapifyMaxArrElementRecursive(array, 0, array.length-1-i);
        }
    }

    public static void mainFn() {
        int[] array = {3,5,9,6,8,20,10,12,18};
        HeapSort heapSort = new HeapSort();
        heapSort.heapifyMaxCompleteArray(array);
        heapSort.printMaxHeapByLevel(array);
        heapSort.sortMaxHeap(array);
        heapSort.printArray(array);

    }
    void printArray(int[] array) {
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }
}
