import java.util.Arrays;

public class Heap {
    int[] items = new int[10];
    int size;

    @Override 
    public String toString() {
        return Arrays.toString(items);
    }

    public void insert(int value){

      

        items[size++] = value;

        var index = size -1;
        var parentIndex = (index -1) / 2;
        
        while(items[index] > items[(index - 1) /2]){
            swap(index, (index - 1) / 2);
            // var tempo = items[parentIndex];
            // items[parentIndex] = items[index];
            // items[index] = tempo;
            index = (index -1) / 2;
            System.out.println(index);
        }

    }
    
    public void swap(int first, int sec){
        var tempo = items[first];
        items[first] = items[sec];
        items[sec] = tempo;
    }

    public void remove(){
        items[0] = items[--size];
        var index = 0;
        while(items[index] < items[(index * 2) + 1] && index < items[(index * 2) +2]){
            var largerChildIndex = 0 ;
            if(items[(index * 2) + 1] > items[(index * 2) +2]){
                largerChildIndex = (index * 2) +1;
            }else{
                largerChildIndex = (index * 2) +2;
            }
            
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
        items[size] = 0;
    }

    public int max(){
        if(items.length <= 0){
            System.out.println("is empty");
        }
        return items[0];
    }
    
}
