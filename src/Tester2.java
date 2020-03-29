
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class Tester2 {

    public static void main(String[] args) {

        MyQueueImplementation myQueue= new MyQueueImplementation();
        myQueue.add("Hola MUndo");
        myQueue.add("Gregorio");
        myQueue.add("MERAZ");
        myQueue.add("Holduing");
        myQueue.add("Testing my queue");

        System.out.println(myQueue);

        myQueue.poll();
        System.out.println(myQueue);
        System.out.println(myQueue.peek());

        System.out.println(myQueue);
        myQueue.poll();
        myQueue.poll();
        System.out.println(myQueue);
        myQueue.remove(1);




     }


}
