public class rotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode first;
    ListNode last;
    int size = 0;
    int count = 0;
    public ListNode rotateRight(int k) {
        // 1234
        var current = first;
        while(current != null){
            current = current.next;
            size++;
        }
        
        for(int i = 0; i < k; i++){
            System.out.println(i);
            var removedItem = removeLast();
            System.out.println(removedItem.toString());
        }
        return first;
    }

    // addFirst
    public void addFirst(int item) {
        var node = new ListNode(item);
        if(first == null){
            first = last = node;
        }else{
            node.next = first;
            first = node;
        }
    }

    // removeLast
    public ListNode removeLast(){
        if(isEmpty()){
            System.out.println("Empty!");
        }
        if(first == last){
            first = last = null;
            size = 0;
            return first;
        }
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
        size--;
        return last;
    }

    public boolean isEmpty() {
        if(first == null && last == null){
            return true;
        }
        return false;
    }

    // getPrevious
    private ListNode getPrevious(ListNode node) {
        var previous = node;
        var current = first;
        while(current != node){
            previous = current;
            current = current.next;
        }
        return previous;
    }
}
