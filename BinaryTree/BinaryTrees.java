import java.lang.Math;


public class BinaryTrees {
    private class Node{
        private Node leftChild;
        private Node rightChild;
        private int value;
        
        public Node(int value){
            this.value = value;
        }

        // public String toString(){
        //     return "this is string" + this.value;
        // }
    }

    private Node root;

    public void add(int item){
        if(root == null){
            root = new Node(item);
        }
        var current = root;
        while(true){
            if(item < current.value){
                if(current.leftChild == null){
                    current.leftChild = new Node(item);
                    break;
                }
                current = current.leftChild;
            }else if(item > current.value){
                if(current.rightChild == null){
                    current.rightChild = new Node(item);
                    break;
                }
                current = current.rightChild;
            }else{
                break;
            }
        }
    }

    public boolean find(int value){
        var current = root;
        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            }else{
                current = current.rightChild;
                System.out.println("yes there is your number " + current.value);
                return true;
            }
        }
        // if(current != null){
        //     System.out.println("not null" + root.value);
        // }else{
        //     System.out.println("null");
        // }
        return false;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        if(root == null){
            return ;
        }
        System.out.println(root.value);
        traverse(root.leftChild);
        traverse(root.rightChild);
    }

    public void preorder(){
        preorder(root);
    }

    private void preorder(Node root){
        if(root == null){
            return;
        }
        preorder(root.leftChild);
        System.out.println(root.value);
        preorder(root.rightChild);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null){
            return 0;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public boolean equl(BinaryTrees root2){
        return equl(root , root2.root);
    }

    private boolean equl(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null){
            return  root1.value == root2.value && equl(root1.leftChild, root2.leftChild) && equl(root1.rightChild, root2.rightChild);
        }
        return false;
    }

    public void makeMess(){
        var tampo = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tampo;
    }

    public boolean validate(){
        return validate(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean validate(Node inputRoot, int max ,int min){
        if(inputRoot == null){
            return true;
        }
        if(inputRoot.value > max || inputRoot.value < min){
            return false;
        }else{
            System.out.println(inputRoot.value + "ss");
            return validate(inputRoot.leftChild, inputRoot.value -1, min) &&
                validate(inputRoot.rightChild, max, inputRoot.value + 1);
        }
    }

    public int printAt(int distance){
        printAt(root, distance);
        return 1;
    }

    private void printAt(Node root, int distance){
        if(root == null){
            return;
        }
        if(distance == 0){
            System.out.println("this is value " + root.value);
        }
        printAt(root.leftChild, distance -1);
        printAt(root.rightChild, distance -1);
    }
}
