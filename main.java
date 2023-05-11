import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class main {
    public static void main(String[] args){




        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(14);
        // queue.add(15);
        // queue.add(16);
        // queue.add(17);
        // queue.add(18);
        // reverse(queue);
        // System.out.println(queue);
        // System.out.println("queue");
        // Array numbers = new Array(3);
        // numbers.insert(13);
        // numbers.insert(13);
        // numbers.insert(16);
        // numbers.insert(15);
        // numbers.insert(19);
        // // numbers.removeAt(4);
        // System.out.println(numbers.indexOf(19));
        // // numbers.pirnt();

        // String str = "hello";
        // StringReverser reverser = new StringReverser();
        // String result = reverser.reverse(str);
        // System.out.println(result);

        // Expression isB = new Expression();
        // Boolean result = isB.isBalanced("(sfd)+[1]{<>}<>");
        // System.out.println(result);

        // linkedlist addlast 
        // LinkedList list = new LinkedList();
        // list.addLast(10);
        // list.addLast(33);
        // list.addLast(53);
        // list.addLast(20);

        // LinkedList addfirst 
        // list.addFirst(10);
        // list.addFirst(20);
        // list.addFirst(30);
        // list.addFirst(40);

        //linkedlist indexof
        // System.out.println(list.indexOf(30));

        // String Reverse 
        // StringReverserExercise sR = new StringReverserExercise();
        // String result = sR.reverseString("wellow");
        // System.out.println(result);

        // Balanced 
        // Balanced balanced = new Balanced();
        // Boolean resu = balanced.balance("(124)<");
        // System.out.println(resu);

        // building a stack 
        // Stack stack = new Stack();
        // stack.push(10);
        // stack.push(20);
        // stack.push(30);
        // stack.pop();
        // System.out.println(stack);



        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(12);
        // queue.add(13);
        // queue.add(14);
        // queue.add(15);
        // queue.add(16);
        // // System.out.println(queue.remove());
        // // System.out.println(queue.remove());
        // // System.out.println(queue);
        // // reverse(queue);

        // // Impliment Queue 
        // QueueExercise queuee = new QueueExercise();
        // queuee.enque(12);
        // queuee.enque(13);
        // // queuee.enque(14);
        // queuee.deque();
        // queuee.deque();
        // // queuee.isEmpty();
        // queuee.enque(16);
        // queuee.enque(17);
        // queuee.deque();
        // queuee.deque();
        // // queuee.enque(18);
        // // queuee.enque(19);
        // // queuee.enque(20);
        
        // String resu = queuee.isEmpty();
        // System.out.println(resu);


        // Queue using stack 
        // QueueUsingStack queu = new QueueUsingStack();
        // queu.enque(1);
        // queu.enque(2);
        // queu.enque(3);
        // // queu.deque();
        // // queu.deque();
        // Integer res = queu.deque();
        // System.out.println(res + "so pu");

    // Queue priorioty 
        // PriorityQueues que = new PriorityQueues();
        // que.add(4);
        // que.add(6);
        // que.add(3);
        // que.add(4);
        // que.add(6);

        // while(!que.isEmpty()){
        //     System.out.println(que.remove());
        // }

        // //hashtables
        // Map<Character, Integer> map = new HashMap<>();
        // // map.put(6, "Thar");
        // // map.put(2, "Thihan");
        // // map.put(3, "MinHtet");
        // // map.put(4, "Thar");
        // String str = "3lelhelehel";
        // for(char item : str.toCharArray()){
        //     if(map.containsKey(item)){
        //         Integer count = map.get(item);
        //         map.put(item, count + 1);
        //     }else{
        //         map.put(item, 1);
        //     }
        //     System.out.println("this is first " + map.get(item));
        // }

        // for(char item : str.toCharArray()){
        //     if(map.get(item) != 1){
        //         System.out.println("str "+ item);
        //         return;
        //     }else{
        //     }
        // }

        //hashTable create
        // Hashtable<Integer ,String> hash = new Hashtable<>();
        // hash.put(1, "que");
        // hash.put(2, "234");
        // hash.put(3, "sdf");
        // var ress = hash.get(2);
        // System.out.println(ress);

        //binarytrees
        // BinaryTrees tree = new BinaryTrees();
        // // tree.add(8);
        // tree.add(11);
        // tree.add(3);
        // tree.add(8);
        // tree.add(4);
        // tree.add(12);


        // BinaryTrees tree2 = new BinaryTrees();
        // tree2.add(8);
        // tree.preorder();
        // tree2.add(3);s
        // tree.add(3);
        // tree.traverse();
        // System.out.println(tree.height());

        //avl tree
        avlTree avltree = new avlTree();
        avltree.insert(10);
        avltree.insert(20);
        avltree.insert(30);
        System.out.println(avltree.rightHeavy());
        // avlTree tree2 = new avlTree();
        // tree2.insert(12);
        // tree2.insert(13);

        // BinaryTrees tree = new BinaryTrees();
        // tree.makeMess();
        // var res = tree.validate();
        // tree.printAt(1);
        // System.out.println(res);
    }



    // public static void reverse(Queue<Integer> queue){
    //     Stack<Integer> stack = new Stack<>();
    //     while(!queue.isEmpty()){
    //         stack.push(queue.remove());
    //     }
    //     while(!stack.isEmpty()){
    //         queue.add(stack.pop());
    //     }
    //     System.out.println(queue+"this is queue");
    // }

}