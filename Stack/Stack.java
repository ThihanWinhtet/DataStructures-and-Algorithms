import java.util.Arrays;

public class Stack {
    private int[] items = new int[3];
    private int count;
    public void push(int item){
        items[count] = item;
        count++;
    }
    public int pop(){
        if(count == 0){
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(items, 0, count));
    }

    public boolean isEmpty(){
        return true;
    }
}
