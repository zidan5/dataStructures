import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DataStructures {

    public  static  int x = 0;
    public static void main(String[] args)  {
       
        Deque<Integer> de_que = new ArrayDeque<Integer>(); //You can also use LinkedList since it does implement Deque interface
        de_que.add(6); // Adding elements to my queue
        de_que.add(2);
        de_que.add(6);
        de_que.add(8);
        de_que.add(3);
        de_que.add(7);
        de_que.add(1);
        de_que.add(4);
        de_que.add(4);


        Iterator value = de_que.iterator(); //Creating an iterator to loop inside ArrayDeque

        int highestUniquesNumber = 0;

        while (value.hasNext()) {

            int subArraySize = 3;

            int[] arrayConvertToInt = new int[de_que.size()];
            Object[] arrayObject = de_que.toArray();

            for(int i =0; i < arrayObject.length; i ++){
                arrayConvertToInt[i] = (int)arrayObject[i]; //Unboxing arrayQue elements from object to int array
            }

            if(!(de_que.size() < subArraySize) ){ //I want only elements from the queue that are equal to subArraySize
                //if Queue length is less than subArraySize then leave remaining elements
                x = subArraySize;
                for(int i= 0; i < subArraySize; i++){ //Loop based only on subArraySize to get unique numbers
                    if(i != 0) {
                        // checking for equal numbers from ---->left to right and from right to left <----
                        if (arrayConvertToInt[0] == arrayConvertToInt[i] || arrayConvertToInt[subArraySize-1] == arrayConvertToInt[(subArraySize-1)-i] ) {
                            x = x - 1;  //Should there be numbers that are equal then subtract 1 from x (x=subArraySize)
                        }
                    }
                    System.out.print(arrayConvertToInt[i]); // Printing number sets
                }
                System.out.println("   Has "+x+" Unique numbers");  // Printing unique number next to its set
                if(highestUniquesNumber <= x){   //Getting the highest unique number
                    highestUniquesNumber = x;
                }

            }

            if(de_que.poll() == null){  // removing the first element from the queue until arrayQueue is empty (FIFO)
                break;
            }
        }
        System.out.println("Highest unique number = "+ highestUniquesNumber);
    }
}

