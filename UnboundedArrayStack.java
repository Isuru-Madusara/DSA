import java.util.EmptyStackException;

public class UnboundedArrayStack<T> {
    private T[] array;
    private int size;

    public UnboundedArrayStack() {
        
        array = (T[]) new Object[2];
        size = 0;
    }

    public void push(T data) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = data;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        
        T item = array[--size];
        array[size] = null;

        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
}