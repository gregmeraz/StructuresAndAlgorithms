public class BSTTester {

    public static void main(String[] args) {
        Program.BST binarySearchTree= new Program.BST(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(22);
        binarySearchTree.insert(17);
        binarySearchTree.insert(34);
        binarySearchTree.insert(7);
        binarySearchTree.insert(1);
        binarySearchTree.insert(35);
        binarySearchTree.insert(27);
        binarySearchTree.insert(16);
        binarySearchTree.insert(30);
        System.out.println("---------------------------------------------------------");
        binarySearchTree.inorderTraversal(binarySearchTree);

        binarySearchTree.remove(22);
        binarySearchTree.remove(17);

        System.out.println("---------------------------------------------------------");
        binarySearchTree.inorderTraversal(binarySearchTree);

    }

}
