package DSA.BINARYTREE.BST;

public class BST {
    public BST(){

    }
    static class NODE {
        int value;
        NODE left;
        NODE right;
        int height;

        public NODE(int value) {

            this.value = value;
        }

        /* public int getvalue(){
             return value;
         }*/
     }
        public NODE root;

        public boolean isempty() {
            return root == null;
        }

        public void display() {
            display(root, "Root node is");
        }

        public int height(NODE node) {
            if (node == null) {
                return -1;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }

        public void display(NODE node, String s) {
            if (node == null) {
                return;
            }
            System.out.println(node.value + s);
            display(node.left, "left node of" + node.value);
            display(node.right, "right node of" + node.value);
        }

        public void insert(int value) {

            root = insert(value, root);
        }

        public NODE insert(int value, NODE node) {
            if (node == null) {
                node = new NODE(value);
                return node;
            }
            if (value < node.value) {
                node.left = insert(value, node.left);
            }
            if (value > node.value) {
                node.right = insert(value, node.right);
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            return node;
        }
        public void populate(int[] nums){

            populatesorted(nums,0,nums.length);
        }
        public void populate1(int[] nums){
            for (int i = 0;i< nums.length;i++){
                insert(nums[i]);
            }
        }
        public void populatesorted(int[] nums, int start, int end) {
            if (start<=end){
                int mid=start+(end-start)/2;
                insert(nums[mid]);
                populatesorted(nums,start,mid);
                populatesorted(nums,mid+1, end);
            }
        }
        public void preorder(){
            preorder(root);
        }
        public void preorder(NODE node){
            if (node==null){
                return;
            }
            System.out.println(node.value);
            preorder(node.left);
            preorder(node.right);
        }
        public void inorder(){
            inorder(root);
        }
        public void inorder(NODE node){
            if (node==null){
                return;
            }
            inorder(node.left);
            System.out.println(node.value);
            inorder(node.right);
        }
        public void postorder(){
            postorder(root);
        }
        public void postorder(NODE node){
            if (node==null){
                return;
            }
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.value);
        }
        public void in(int[] nums){
            for (int i=0;i< nums.length;i++){
                insert(nums[i]);
            }
        }
        public boolean balance()
        {
            return balance(root);
        }

        private boolean balance(NODE node) {
            if (node == null) {
                return true;
            }
            return Math.abs(height(node.left) - height(node.right)) <= 1 && balance(node.left) && balance(node.right);
        }

    }


