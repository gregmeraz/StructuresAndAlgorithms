import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {

     String value;
     List<Node> children = new ArrayList<>();


    public Node(String value) {
        this.value = value;
    }

    public Node addChild(String name) {
        Node child = new Node(name);
        children.add(child);
        return this;
    }

    public List<String> breadthFirstSearch(List<String> array) {
        LinkedList<Node> queue= new LinkedList<>();
        queue.offer(this);

        while(!queue.isEmpty()){
            for(int i=0; i<queue.peek().children.size(); i++){
                queue.offer(queue.peek().children.get(i));
            }
            array.add(queue.poll().value);
        }

        return array;
    }


}
