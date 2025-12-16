import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly<T> {

    private Queue<T> q1;
    private Queue<T> q2;

    public QueueStackPushFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T data) {
        q1.add(data);
    }

    public T pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        T popped = q1.remove();

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }
}
