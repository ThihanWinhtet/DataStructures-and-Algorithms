import java.util.Arrays;

public class QueueExercise {
    
    Integer count = 5;
    int[] array = new int[count];
    Integer front = 0;
    Integer rear = 0;
    public Integer enque(int item){
        if(array[rear] != 0){
            System.out.println("arrar is full");
            return 1;
        }
        array[rear] = item;
        rear = (rear+1) % array.length;
        System.out.println(Arrays.toString(array) + "this is front" + rear+ " c " + count);
        
        return 1;
    }

    public Integer deque(){
        array[front] = 0;
        front = (front+1)% array.length;
        System.out.println(Arrays.toString(array)+ "this is final" + front);
        return 1;
    }

    public String isEmpty(){
        for(int i=0; i<array.length; i++){
            if(array[i] !=0){
                System.out.println(array[i]+"check");
                return "is not empty";
            }
        }
        return "is empty";
    }
}
