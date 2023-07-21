//ALE

import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      int n = array.size();
      int lastIndex = n - 1;
      int firstParentIndex = (lastIndex - 1) / 2;
      for (int cur = firstParentIndex; cur >= 0; cur--) {
        siftDown(cur, n - 1, array);
      }
      return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      while (2 * currentIdx + 1 <= endIdx) {
        int lChild = 2 * currentIdx + 1;
        int rChild = lChild + 1;
        int swapIdx = -1;
        if (rChild > endIdx || heap.get(lChild) <= heap.get(rChild)) {
          swapIdx = lChild;
        } else {
          swapIdx = rChild;
        }

        if (heap.get(swapIdx) < heap.get(currentIdx)) {
          swap(heap, currentIdx, swapIdx);
          currentIdx = swapIdx;
        } else {
          return;
        }
      }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      while (currentIdx > 0) {
        int parentIdx = (currentIdx - 1) / 2;
        if (heap.get(parentIdx) > heap.get(currentIdx)) {
          swap(heap, currentIdx, parentIdx);
          currentIdx = parentIdx;
        } else {
          break;
        }
      }
    }

    public int peek() {
      int n = heap.size();
      if (n > 0)
        return heap.get(0);
      return -1;
    }

    public int remove() {
      int n = heap.size();
      if (n > 0) {
        swap(heap, 0, n - 1);
        int removed = heap.get(n - 1);
        heap.remove(n - 1);
        siftDown(0, heap.size() - 1, heap);
        return removed;
      }
      return -1;
    }

    public void insert(int value) {
      heap.add(value);
      siftUp(heap.size() - 1, heap);
    }

    private void swap(List<Integer> heap, int x, int y) {
      int temp = heap.get(x);
      heap.set(x, heap.get(y));
      heap.set(y, temp);
    }
  }
}

// Std Implementation

// Priority Queue implementation in Java

class Heap {
  // Function to heapify the tree
  void heapify(ArrayList<Integer> hT, int i) {
    int size = hT.size();
    // Find the largest among root, left child and right child
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < size && hT.get(l) > hT.get(largest))
      largest = l;
    if (r < size && hT.get(r) > hT.get(largest))
      largest = r;

    // Swap and continue heapifying if root is not largest
    if (largest != i) {
      int temp = hT.get(largest);
      hT.set(largest, hT.get(i));
      hT.set(i, temp);

      heapify(hT, largest);
    }
  }

  // Function to insert an element into the tree
  void insert(ArrayList<Integer> hT, int newNum) {
    int size = hT.size();
    if (size == 0) {
      hT.add(newNum);
    } else {
      hT.add(newNum);
      for (int i = size / 2 - 1; i >= 0; i--) {
        heapify(hT, i);
      }
    }
  }

  // Function to delete an element from the tree
  void deleteNode(ArrayList<Integer> hT, int num) {
    int size = hT.size();
    int i;
    for (i = 0; i < size; i++) {
      if (num == hT.get(i))
        break;
    }

    int temp = hT.get(i);
    hT.set(i, hT.get(size - 1));
    hT.set(size - 1, temp);

    hT.remove(size - 1);
    for (int j = size / 2 - 1; j >= 0; j--) {
      heapify(hT, j);
    }
  }

  // Print the tree
  void printArray(ArrayList<Integer> array, int size) {
    for (Integer i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  // Driver code
  public static void main(String args[]) {

    ArrayList<Integer> array = new ArrayList<Integer>();
    int size = array.size();

    Heap h = new Heap();
    h.insert(array, 3);
    h.insert(array, 4);
    h.insert(array, 9);
    h.insert(array, 5);
    h.insert(array, 2);

    System.out.println("Max-Heap array: ");
    h.printArray(array, size);

    h.deleteNode(array, 4);
    System.out.println("After deleting an element: ");
    h.printArray(array, size);
  }
}