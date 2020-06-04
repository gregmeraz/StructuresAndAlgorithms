import java.util.Set;
import java.util.TreeSet;

public class TreesTester {

    public static void main(String[] args) {
        Set<Integer> myTree= new TreeSet<>();
        myTree.add(10);
        myTree.add(5);
        myTree.add(3);
        myTree.add(4);
        myTree.add(11);
        myTree.add(15);
        myTree.add(2);
        myTree.add(12);

        System.out.println(myTree);

        myTree.remove(10);
        System.out.println(myTree);
    }

}
