import java.util.Stack;

public class StackQueueEnqueueFriendly<T> {
    private Stack<T> s1; // for enqueue
    private Stack<T> s2; // for dequeue

    public StackQueueEnqueueFriendly() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(T data) {
        s1.push(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int size() {
        return s1.size() + s2.size();
    }
}