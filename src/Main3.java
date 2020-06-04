import java.util.ArrayList;

public class Main3 {

    static Node test4;

    public static void main(String[] args) {
        test4 = new Node("A");
        test4.addChild("B").addChild("C").addChild("D");
        test4.children.get(0).addChild("E").addChild("F");
        test4.children.get(2).addChild("G").addChild("H");
        test4.children.get(0).children.get(1).addChild("I").addChild("J");
        test4.children.get(2).children.get(0).addChild("K");

        System.out.println(test4.breadthFirstSearch(new ArrayList<>()));

    }






}
