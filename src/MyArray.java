import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArray<T> implements MyList<T> {
    private Class<T> cls;
    private T data[];
    int nextIndex;

    public MyArray(Class<T> cls){
        this.cls = cls;
        data = (T[]) Array.newInstance(cls, 10);
        nextIndex = 0;
    }

    public MyArray(Class<T> cls, int size){
        this.cls = cls;
        data = (T[]) Array.newInstance(cls, size);
        nextIndex = 0;
    }

    @Override
    public boolean add(int index, T o) {
        if(index >= data.length){
            throw new IndexOutOfBoundsException();
        }

        T temp = data[index];
        this.grow();
        System.out.println(data[this.size()-1]);
        for(int i = this.size() - 1; i >= index + 1; i--){
            this.swap(i, i-1);
        }

        data[index] = o;
        nextIndex++;

        return true;
    }

    @Override
    public boolean add(T o) {
        if(nextIndex >= data.length){
            this.grow();
        }

        data[nextIndex] = o;
        nextIndex++;

        return true;
    }

    @Override
    public boolean clear() {
        data = (T[]) Array.newInstance(cls, this.size());
        nextIndex = 0;

        return true;
    }

    @Override
    public boolean contains(T o) {
        for(int i = 0; i < this.size(); i++){
            if(data[i] == o){
                return true;
            }
        }

        return false;
    }

    @Override
    public T get(int index) {
        if(index >= this.size()){
            throw new IndexOutOfBoundsException();
        }

        T t = data[index];

        return t;
    }

    @Override
    public int indexOf(T o) {
        for(int i = 0; i < this.size(); i++){
            if(data[i] == o){
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(this.nextIndex == 0){
            return true;
        }

        return false;
    }

    @Override
    public T remove(int index) {
        T toRemove = data[index];

        for(int i = index; i < this.size() - 1; i++){
            this.swap(i, i+1);
        }
        this.shrink();
        nextIndex--;

        return toRemove;
    }

    @Override
    public T remove(T o) {
        int index = this.indexOf(o);

        return this.remove(index);
    }

    @Override
    public boolean set(int index, T element) {
        if(index >= this.size()){
            throw new IndexOutOfBoundsException();
        }

        data[index] = element;

        return true;
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public MyArray subList(int fromIndex, int toIndex) {
        if(fromIndex > toIndex){
            System.out.println("Starting index cannot be greater than ending.");
            System.exit(0);
        }

        if(fromIndex >= this.size() || toIndex >= this.size()){
            throw new IndexOutOfBoundsException();
        }

        int sublistSize = toIndex - fromIndex;
        MyArray<T> sublist = new MyArray(cls, sublistSize);

        for(int i = fromIndex;i <= toIndex; i++){
            sublist.add(data[i]);
        }

        return sublist;
    }

    //TODO: remove empties at end of array
    @Override
    public T[] toArray() {
        T dataArray[] = (T[]) Array.newInstance(cls, nextIndex);
        for(int i = 0; i < nextIndex; i++){
            dataArray[i] = data[i];
        }

        return dataArray;
    }

    @Override
    public boolean swap(int position1, int position2) {
        if(position1 >= this.size() || position2 >= this.size()){
            throw new IndexOutOfBoundsException();
        }

        T temp;

        temp = data[position1];
        data[position1] = data[position2];
        data[position2] = temp;

        return true;
    }

    @Override
    public boolean shift(int position) {
        int j;
        for(int i = 0; i < this.size(); i++){
            j = i + position;
            if(j >= 0){
                if(j >= this.size()){
                    this.grow();
                }
               data[j] = data[i];
            }
        }

        return true;
    }

    private boolean grow(){
        data = Arrays.copyOf(data, nextIndex + 1);

        return true;
    }

    private boolean shrink(){
        data = Arrays.copyOf(data, nextIndex - 1);

        return true;
    }


    public String toString(){
        String s = "[ ";
        for(int i = 0; i < nextIndex; i++){
            s+= data[i] + " ";
        }
        s += "]";
        return s;
    }

}
