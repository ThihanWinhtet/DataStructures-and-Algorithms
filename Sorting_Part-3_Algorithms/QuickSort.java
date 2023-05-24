public class QuickSort {

    // QuickSort bs = new QuickSort();
    // int[] array = {8,9,7,5,1,2,3,4,0};
    // bs.sort(array);
    // System.out.println(Arrays.toString(array));
    // ------------***------------ //


    public void sort(int[] array){
        sort(array, 0, array.length-1);
    }
    private void sort(int[] array, int start, int end){
        //baseline
        if(start >= end){
            return;
        }
        // paviot
        var boundary = partition(array, start, end);
        // sortLeft
        sort(array, start, boundary - 1);
        // sortRight
        sort(array, boundary + 1, end);
        
    }
    private int partition(int[] array, int start, int end){
        var paviot = array[end];
        var boundary = start - 1;
        for(int i = start; i <= end; i++){
            if(array[i] <= paviot){
                swap(array, i, ++boundary);
            }

        }
        return boundary;
    }
    private void swap(int[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] =array[index2];
        array[index2] = temp;
    }

}
