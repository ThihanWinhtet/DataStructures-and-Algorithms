import java.util.Arrays;

public class BubbleSort {

    // BubbleSort bs = new BubbleSort();
    //     int[] array = {5,4,1,2,3,9};
    //     bs.sort(array);
    // ------------***------------ //

    public void sort(int[] array){
        boolean isSorted;
        for(int i=0; i<array.length; i++){
            isSorted = true;
            for(int j=1; j<array.length; j++){
                if(array[j] < array[j-1]){
                    var temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                return;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    
    
}