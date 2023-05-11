import java.util.Arrays;

public class PriorityQueues {
    int[] array = new int[5];
    int count;
    public void add(int item){
        int i ;
        for(i= count-1; i >= 0; i--){
            if(array[i] > item){
                array[i+1] = array[i];
            }
            else{
                break;
            }
        }
        array[i + 1 ] = item;
        count++;
        System.out.println(Arrays.toString(array) + " this is array " + count);
    }

    public int remove(){
        if(isEmpty()){
            throw new IllegalAccessError();
        }
        return array[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
