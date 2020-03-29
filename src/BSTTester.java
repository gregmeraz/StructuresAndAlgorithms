public class BSTTester {

    public static void main(String[] args) {
        Program.BST binarySearchTree= new Program.BST(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(10);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(14);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(13);

        binarySearchTree.postOrderTraversal(binarySearchTree);
        System.out.println("---------------------------------------------------------");
        binarySearchTree.inorderTraversal(binarySearchTree);

        System.out.println(binarySearchTree.contains(14));
        System.out.println(binarySearchTree.contains(100));
        System.out.println(binarySearchTree.contains(13));
        System.out.println(binarySearchTree.contains(15));
        binarySearchTree.insert(15);
        System.out.println(binarySearchTree.contains(15));

        binarySearchTree.remove(13);
        binarySearchTree.remove(15);
        binarySearchTree.remove(10);

        binarySearchTree.inorderTraversal(binarySearchTree);

    }

}
