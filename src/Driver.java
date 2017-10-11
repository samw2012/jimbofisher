/**
 * Created by Samuel on 10/2/2017.
 */
public class Driver {

    public static void main(String args[]){
      /*  MyArray<Integer> myArray = new MyArray<Integer>(Integer.class);
        System.out.println(myArray.isEmpty());
        for(int i = 0; i < 21; i++){
            myArray.add(i);
        }

        System.out.println(myArray.toString());
        System.out.println(myArray.size());
        Integer []myIntArray = myArray.toArray();
        System.out.println(myIntArray.length);

        if(myArray.contains(20)){
            System.out.println("Success");
        }

        myArray.add(5, 22);
        myArray.add(5, 56);
        myArray.add(5, 59);
        myArray.add(5, 84);
        System.out.println("Index of 5: " + Integer.toString(myArray.indexOf(5)));
        System.out.println(myArray.toString());
        System.out.println(myArray.isEmpty());
        myArray.remove(5);
        System.out.println(myArray.toString());
        myArray.remove(5);
        System.out.println(myArray.toString());*/

        MyLinkedList<Integer> myList = new MyLinkedList<Integer>(Integer.class);
        myList.add(-1, 12);
        myList.add(-1, 15);
        myList.add(-1, 4);
        myList.add(25);
        myList.add(30);
        myList.add(35);
        System.out.println(myList.toString());
        myList.set(1, 5);
        System.out.println(myList.toString());
        System.out.println(myList.contains(5));
        System.out.println(myList.toArray());
        myList.swap(0, 2);
        System.out.println(myList.toString());
        MyLinkedList<Integer> subList = myList.subList(2, 5);
        System.out.println(subList.toString());

    }
}
