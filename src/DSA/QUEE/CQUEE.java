package DSA.QUEE;

public class CQUEE {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public CQUEE(int n) {
        size = n;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean enqueue(int value) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            // System.out.println("Queue is Full");
            return false;
        } else if (front == -1) {
            front = rear = 0;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = value;
        return true;
    }

    public int dequeue() {
        if (front == -1) {
            // System.out.println("Queue is Empty");
            return -1;
        }
        int ans = arr[front];
        arr[front] = -1;
        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return ans;
    }
}
