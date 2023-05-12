

public class avlTree {
    private class AVLNode{
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }

    }

    private AVLNode root;
    public void insert(int value){
        root  = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value){
        if(root == null){
            root = new AVLNode(value);
        }
        System.out.println(root.value + " this is VALUE");
        if(value < root.value){
            System.out.println(root.value + " this is left");
            root.leftChild = insert(root.leftChild, value);
        }
        
        if(value > root.value){
            System.out.println(root.value + " this is right");
            root.rightChild = insert(root.rightChild, value);
        }
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        
        // int diff = 0;
        // if(root.leftChild != null && root.rightChild != null){
        // diff = height(root.leftChild) - height(root.rightChild);
        // }else if(root.leftChild == null && root.rightChild != null){
        //     diff = 0 - height(root.rightChild);
        // }else if(root.rightChild == null && root.leftChild !=null){
        //     diff = height(root.leftChild) - 0;
        // }
        // if(diff < -1 ){
        //     System.out.println(root.rightChild.value + " right is heavy");
        // }
        // if(diff > 1){
        //     System.out.println(root.leftChild.value + " left is heavy");
        // }else{
        //     System.out.println("balance");
        // }
        // System.out.println(diff + "this is final");
        return balance(root);
    }

    public AVLNode balance(AVLNode root){
        if(leftHeavy()){
            System.out.println("yeah left is heavy " + balanceFactor(root));
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = leftRotate(root.leftChild);
                // System.out.println("n to be rotate l " + root.leftChild.value);
            return rightRotate(root);
            // System.out.println("n to be rotate r " + root.value);

            
        }else if(rightHeavy()){
            System.out.println("yeah r is heavy " + balanceFactor(root));
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rightRotate(root.rightChild);
                // System.out.println("n to be rotate r " + root.rightChild.value);  
            return leftRotate(root);  
            // System.out.println("n to be rotate l " + root.value);
     
        }return root;
    }

    public AVLNode leftRotate(AVLNode root){
        var newroot = root.rightChild;

        root.rightChild = newroot.leftChild;
        newroot.leftChild = root;

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        newroot.height = Math.max(height(newroot.leftChild), height(newroot.rightChild)) + 1;

        return newroot;
    }

    public AVLNode rightRotate(AVLNode root){
        var newroot = root.leftChild;

        root.leftChild = newroot.rightChild;
        newroot.rightChild = root;

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        newroot.height = Math.max(height(newroot.leftChild), height(newroot.rightChild)) + 1;

        return newroot;
    }

    public boolean leftHeavy(){
        // if(balanceFactor(root) > 1){
        //     return true;
        // }
        return balanceFactor(root) > 1;
    }

    public boolean rightHeavy(){
        // if(balanceFactor(root) < -1){
        //     return true;
        // }
        return balanceFactor(root) < -1;
    }

    private int balanceFactor(AVLNode node){
        if(node == null){
            return 0;
        }
        // System.out.println(height(node.leftChild) - height(node.rightChild) + " b value");
        return height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node){
        if(node == null){
            return -1;
        }
        return node.height;
        
    }
}
