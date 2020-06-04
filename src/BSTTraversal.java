import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if(tree==null){
            return array;
        }
        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if(tree==null){
            return array;
        }
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if(tree==null){
            return array;
        }
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
    }

    public static void insert(int value, BST root){
        if(value<root.value){
            if(root.left==null){
                root.left= new BST(value);
            }
            else{
                insert(value, root.left);
            }
        }
        else{
            if(root.right==null){
                root.right=new BST(value);
            }
            else{
                insert(value, root.right);
            }
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);

        insert(23, root);
        insert(6, root);


        System.out.println(inOrderTraverse(root, new ArrayList<>()));
        System.out.println(preOrderTraverse(root, new ArrayList<>()));
        System.out.println(postOrderTraverse(root, new ArrayList<>()));


        List<Integer> inOrder = Arrays.asList(new Integer[]{1, 2, 5, 5, 10, 15, 22});
        List<Integer> preOrder = Arrays.asList(new Integer[]{10, 5, 2, 1, 5, 15, 22});
        List<Integer> postOrder = Arrays.asList(new Integer[]{1, 2, 5, 5, 22, 15, 10});

    }

}
