public class IntTree {

    private IntTree left;
    private IntTree right;
    private Integer element;

    public static void main(String[] args) {
        IntTree tree= new IntTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        System.out.println("finished inserting");
        tree.inorderTraversal(tree);
    }

    public void insert(Integer newElement){
        if(this.element==null){
            return;
        }
        if(newElement>this.element){
            this.right.insert(newElement);
        }
        else {
            this.left.insert(newElement);
        }

    }

    public void inorderTraversal(IntTree node){
        if(node==null){
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }


}