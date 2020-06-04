import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinHeightBST {

    public static BST minHeightBst(List<Integer> array) {

        int rootValue=array.get(array.size()/2);
        BST tree= new BST(rootValue);
        minimalInsertLeft(tree, array, true);
        return tree;
    }

    public static void minimalInsertLeft(BST tree, List<Integer> array, boolean isFirtsRun){
        if(array.isEmpty()){
            return;
        }
        if(array.size()==1){
            tree.insert(array.get(0));
            return;
        }

        Integer middleElement = array.get(array.size() / 2);
        int middleElementIndex=array.indexOf(middleElement);
        if(!isFirtsRun){
            tree.insert(middleElement);
        }
       minimalInsertLeft(tree, array.subList(0, array.size()/2), false);
       minimalInsertLeft(tree, array.subList(middleElementIndex+1, array.size()), false);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
    public static LinkedList<Integer> breadthFirstSearch(Queue<BST> queue, LinkedList<Integer> result){

            while(!queue.isEmpty()){
                    BST bst= queue.poll();
                    result.add(bst.value);
                    if(bst.left!=null){
                        queue.add(bst.left);
                    }
                    if(bst.right!=null){
                        queue.add(bst.right);
                    }
               return  breadthFirstSearch(queue, result);
            }
           return result;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,2,5,7,10,13,14,15,22);
        BST tree=minHeightBst(array);
        Queue<BST> bfsQueue= new LinkedList<>();
        bfsQueue.add(tree);
        System.out.println(breadthFirstSearch(bfsQueue, new LinkedList<>()));
    }
}
