import java.util.ArrayList;

class MyCircularQueue {
    final int[] a;
    int front = 0, rear = -1, len = 0;

    public MyCircularQueue(int k) {
        a = new int[k];
    }

    public boolean enQueue(int val) {
        if (!isFull()) {
            rear = (rear + 1) % a.length;
            a[rear] = val;
            len++;
            return true;
        } else
            return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % a.length;
            len--;
            return true;
        } else
            return false;
    }

    public int Front() {
        return isEmpty() ? -1 : a[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : a[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == a.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

class CircularQueue {

    private int size, front, rear; // Variable declaration

    private ArrayList<Integer> queue = new ArrayList<Integer>(); // Declaring Integer array list

    CircularQueue(int size) // Constructor
    {
        this.size = size;
        this.front = this.rear = -1;
    }

    public void enQueue(int value) // Insertion Function
    {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) // Condition if queue is full
        {
            System.out.print("Queue Full!");
        } else if (front == -1) // Condition for empty queue.
        {
            front = 0;
            rear = 0;
            queue.add(rear, value);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, value);
        } else {
            rear = (rear + 1);

            // Adding a new element if

            if (front <= rear) {
                queue.add(rear, value);
            } // Else updating old value
            else {
                queue.set(rear, value);
            }
        }
    }

    public int deQueue()
    // Dequeue Function
    {
        int temp;

        if (front == -1)
        // Checking for empty queue
        {
            System.out.print("Queue Empty!");
            return -1;
        }
        temp = queue.get(front);
        if (front == rear)
        // For only one element
        {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        return temp;
        // Returns dequeued element
    }

    public void displayQueue() // Display the elements of queue
    {
        if (front == -1) // Check for empty queue
        {
            System.out.print("Queue is Empty");
            return;
        }
        System.out.print("Elements in the " + "circular queue are: ");
        if (rear >= front)

        // if rear has not crossed the size limit
        {
            for (int i = front; i <= rear; i++) // print elements using loop
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            for (int i = 0; i <= rear; i++) // Loop for printing elements from 0th index till rear position
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5); // Initialising new object of CircularQueue class.

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.displayQueue();
        int x = queue.deQueue();
        if (x != -1) // Check for empty queue

        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        x = queue.deQueue();
        if (x != -1) // Check for empty queue

        {

            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        queue.displayQueue();
        queue.enQueue(6);
        queue.enQueue(7);
        queue.displayQueue();
        queue.enQueue(8);

    }

}