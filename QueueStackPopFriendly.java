import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly<T> {

    private Queue<T> q1;
    private Queue<T> q2;

    public QueueStackPopFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T data) {
        q2.add(data);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public T pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }
}
