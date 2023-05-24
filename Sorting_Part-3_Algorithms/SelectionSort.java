import java.util.Arrays;

public class SelectionSort {

    // SelectionSort bs = new SelectionSort();
    //     int[] array = {4,1,2,};
    //     bs.sort(array);
    // ------------***------------ //
    
    public void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            var minIndex = 0;
            for(int j = i; j < array.length; j++){
                if(array[j] < array[i]){
                    minIndex = j;
                    var temp = array[minIndex];
                    array[minIndex] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
