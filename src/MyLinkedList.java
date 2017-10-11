import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyLinkedList<T> implements MyList<T> {
    private Class<T> cls;
    private Node current;
    private Node firstNode;
    private int counter;

    public MyLinkedList(Class<T> cls){
        this.cls = cls;
        this.firstNode = null;
        this.current = null;
        this.counter = 0;
    }

    @Override
    public boolean add(int index, T o) {
        int localCount = 0;
        Node<T> nodeToInsert = new Node(o);
        Node<T> node = firstNode;
        if(counter <= 0)
        {
            if(index > counter)
            {
                System.out.println("Index out of bounds");
                System.exit(0);
            }
            this.add(o);
        }
        else if(index == -1)
        {
            this.firstNode = nodeToInsert;
            this.firstNode.setNextNode(node);
            counter++;
        }
        else
        {
            while(node.getNextNode() != null)
            {
                if(localCount + 1 == index)
                {
                    Node<T> newNode = node.getNextNode();
                    node.setNextNode(nodeToInsert);
                    nodeToInsert.setNextNode(newNode);
                }
                node = node.getNextNode();
                localCount++;
            }
        }

        return false;
    }

    @Override
    public boolean add(T o) {
        Node<T> temp = new Node(o);
        if(firstNode == null)
        {
            firstNode = temp;
            firstNode.setNextNode(null);
        }
        else if(firstNode != null)
        {
            current.setNextNode(temp);
        }
        current = temp;
        counter++;
        return false;
    }

    @Override
    public boolean clear() {
        this.firstNode = null;
        this.counter = -1;

        return true;
    }

    @Override
    public boolean contains(T o) {
        if(firstNode.data == o){
            return true;
        }

        Node<T> temp = firstNode;
        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
            if(temp.data == o){
                return true;
            }
        }

        return false;
    }

    @Override
    public T get(int index) {
        int localCount = 0;
        Node<T> temp = firstNode;

        if(index == 0){
            return temp.data;
        }

        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
            localCount++;
            if(localCount == index){
                return temp.data;
            }
        }

        return null;
    }

    @Override
    public int indexOf(T o) {
        int localCount = 0;
        Node<T> temp = firstNode;

        if(firstNode.data == o){
            return localCount;
        }

        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
            localCount++;
            if(temp.data == o){
                return localCount;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(firstNode == null){
            return true;
        }

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
        int localCount = 0;
        Node<T> temp = firstNode;

        if(index == 0){
            firstNode.data = element;
            return true;
        }

        while(temp.getNextNode() != null){
            temp = temp.getNextNode();
            localCount++;
            if(index == localCount){
                temp.data = element;
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public MyLinkedList subList(int fromIndex, int toIndex) {
        if(fromIndex > toIndex){
            System.out.println("Starting index cannot be greater than ending.");
            System.exit(0);
        }

        if(fromIndex >= this.size() || toIndex >= this.size()){
            throw new IndexOutOfBoundsException();
        }

        int sublistSize = toIndex - fromIndex;
        MyLinkedList<T> sublist = new MyLinkedList(this.cls);

        Node<T> temp = firstNode;
        int localCount = 0;

        while(firstNode.getNextNode() != null){
            if(localCount < fromIndex){
                temp = temp.getNextNode();
                localCount++;
            } else if(localCount <= toIndex){
                    sublist.add(temp.data);
                    if(localCount <= this.counter) {
                        temp = temp.getNextNode();
                    }
                    localCount++;
            } else {
                break;
            }
        }


        return sublist;
    }

    @Override
    public T[] toArray() {
        T[] arr = (T[]) Array.newInstance(cls, counter);
        int localCount = 0;
        if(this.isEmpty()){
            return arr;
        }
        Node<T> temp = firstNode;
        arr[localCount] = temp.data;

        while(temp.getNextNode() != null) {
            temp = temp.getNextNode();
            localCount++;
            arr[localCount] = temp.data;
        }

        return arr;
    }


    @Override
    public boolean swap(int position1, int position2) {
        int localCount = 0;
        Node<T> nodeAtOne = new Node<T>();
        Node<T> nodeAtTwo = new Node<T>();
        Node<T> node = firstNode;

        if(position1 == 0){
            nodeAtOne = firstNode;
        }
        if(position2 == 0){
            nodeAtTwo = firstNode;
        }

        while(node.getNextNode() != null)
        {
            node = node.getNextNode();
            localCount++;
            if(localCount == position1){
                nodeAtOne = node;
            }
            if(localCount == position2){
                nodeAtTwo = node;
            }
        }

        T tempData = nodeAtOne.data;
        nodeAtOne.data = nodeAtTwo.data;
        nodeAtTwo.data = tempData;

        return true;
    }

    @Override
    public boolean shift(int position) {

        return false;
    }

    public String toString()
    {
        String s = "";
        Node<T> node = new Node();
        node = firstNode;
        while(node.getNextNode() != null)
        {
            s += node.toString() + "\n";
            node = node.getNextNode();
        }
        s += node.toString() + "\n";
        s += "Count: " + this.counter;
        return s;
    }

}

class Node<T> {
    T data;
    Node nextNode;

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node(T data1) {
        this.data = data1;
    }

    public Node() {

    }

    public String toString() {
        String s = "" + data;
        return s;
    }
}