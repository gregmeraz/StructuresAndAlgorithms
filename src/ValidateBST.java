public class ValidateBST {

    public static boolean validateBst(BST tree) {
        if (tree != null) {
            if (tree.left != null && tree.right != null) {
                validateBst(tree.right);
                validateBst(tree.left);
                if (tree.value > tree.left.value || tree.value <= tree.right.value) {
                    return false;
                }
            } else if (tree.left == null && tree.right != null) {
                validateBst(tree.right);
                if (tree.value <= tree.right.value) {
                    return false;
                }
            } else if (tree.left != null) {
                if (tree.value > tree.left.value) {
                    return false;
                }
                validateBst(tree.left);
            }
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
