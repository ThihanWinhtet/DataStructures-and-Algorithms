public class LinkedList {

    private class Node{
        private int value;
        private Node next;

        public Node (int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;

    public void addLast(int item){
        Node node = new Node(item);
        if(first == null){
            first = last = node;
        }else{
            last.next = node;
            last = node;
        }
    }

    public void addFirst (int item){
        Node node = new Node(item);
        if(first == null){
            first = last = node;
        }else{
            first.next = node;
            first = node;
        }
    }

    // public int indexOf(int item){
    //     Integer index = 0;
    //     Node current = first;
    //     while(current!= null ){
    //         if(current.value == item){
    //             return index;
    //         }
    //         current = current.next;
    //         index++;
    //     }
    //     return -1;
    // }

        

        public int indexOf(int item ){
            Integer index = 0;
            Node current = first;
            while(current != null){
                if(current.value == item){
                    System.out.println(current.value);
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    
    
}
