public class ArrayStack<T> implements IStack<T> {
    int topIndex;
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialSize) {
    array = (T[]) new Object[initialSize];
    topIndex = 0;
    }
    @SuppressWarnings("unchecked")
    public ArrayStack() {
    array = (T[]) new Object[999];
    topIndex = 0;
    }
    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }

    @Override
    public boolean isFull() {
        return topIndex==array.length;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[--topIndex];
    }

    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            throw new FullStackException();
        array[topIndex++]=elem;

    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();
        return array[topIndex-1];
    }
}

