public class MyCircularLinkedList<T> implements MyList<T> {

    @Override
    public boolean add(int index, T o) {
        return false;
    }

    @Override
    public boolean add(T o) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public boolean contains(T o) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T remove(T o) {
        return null;
    }

    @Override
    public boolean set(int index, T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public MyList subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public boolean swap(int position1, int position2) {
        return false;
    }

    @Override
    public boolean shift(int position) {
        return false;
    }
}
