class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            recursivelyInsert(value, this);
            return this;
        }

        public void postOrderTraversal(BST bst){
            if(bst==null){
                return;
            }
            postOrderTraversal(bst.left);
            postOrderTraversal(bst.right);
            System.out.println("(" +bst.value + ") ");
        }

        public void inorderTraversal(BST bst){

            if(bst==null){
                return;
            }
            inorderTraversal(bst.left);
            System.out.println("(" +bst.value + ") ");
            inorderTraversal(bst.right);
        }

        private boolean searchRecursively(int valueToSearch, BST node){
            if(node!=null&&valueToSearch==node.value){
                return true;
            }
            else if(node==null){
                return false;
            }
            if(valueToSearch<node.value){
               return searchRecursively(valueToSearch, node.left);
            }
            else if(valueToSearch>node.value){
               return searchRecursively(valueToSearch, node.right);
            }
            return false;
        }

        private BST recursivelyInsert(int value, BST bst){
            if(value<bst.value){
                if(bst.left==null){
                    bst.left=new BST(value);
                }
                else{
                    recursivelyInsert(value, bst.left);
                }
            }
            else if(value>bst.value){
                if(bst.right==null){
                    bst.right=new BST(value);
                }
                else{
                    recursivelyInsert(value, bst.right);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            return searchRecursively(value, this);
        }

        private void removeRecursively(int value, BST node){
            if(node!=null&&node.left!=null&&value==node.left.value){
                if(node.left.left!=null&&node.left.right!=null){

                }

               else if(node.left.left==null&&node.left.right==null){
                   node.left=null;
                   return;
               }
               else if(node.left.left!=null){
                   BST tempNode=node.left.left;
                   node.left.left=null;
                   node.left=tempNode;
                   return;
               }
               else {
                   BST tempNode=node.left.right;
                   node.left.right=null;
                   node.left=tempNode;
                   return;
               }
            }
            else if(node!=null&&node.right!=null&&value==node.right.value){
                if(node.right.left!=null&&node.right.right!=null){

                }

                else if(node.right.left==null&&node.right.right==null){
                    node.right=null;
                    return;
                }
                else if(node.right.left!=null){
                    BST tempNode=node.right.left;
                    node.right.left=null;
                    node.right=tempNode;
                    return;
                }
                else{
                    BST tempNode=node.right.right;
                    node.right.right=null;
                    node.right=tempNode;
                    return;
                }
            }
            else if(node==null){
                return;
            }
            if(value<node.value){
                removeRecursively(value, node.left);
            }
            else if(value>node.value){
                removeRecursively(value, node.right);
            }
        }

        public BST remove(int value) {
            removeRecursively(value, this);
            return this;
        }
    }
}
