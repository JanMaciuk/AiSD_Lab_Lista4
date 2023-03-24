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
    public void reverse()  {
        ArrayStack<T> stack = new ArrayStack<T>(size());
        while (!isEmpty()) { // wycinam wszystkie elementy ze stosu i wklejam do nowego stosu
            try { stack.push(pop()); }
            catch (Exception e) { e.printStackTrace(); } //jest warunek !isEmpty i ten sam rozmiar, więc nie powinno dojść do błędu
        }
        while (!stack.isEmpty()) { // zapisuje elementy z powrotem do startego stosu
            try { push(stack.pop()); }
            catch (Exception e) { e.printStackTrace(); } //jest warunek !isEmpty i ten sam rozmiar, więc nie powinno dojść do błędu
        }
    }
}

