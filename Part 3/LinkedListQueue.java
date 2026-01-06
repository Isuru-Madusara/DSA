
class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue {
    private QueueNode front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    public void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return removed;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        QueueNode current = front;
        System.out.print("Front -> ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("Rear");
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();
        queue.dequeue();
        queue.display();
    }
}
