public class Merge {

    // Merge bs = new Merge();
    // int[] array = {8,9,7,5,1,2,3,4,0};
    // bs.Sort(array);
    // System.out.println(Arrays.toString(array));
    // ------------***------------ //
    
    public void Sort(int[] array){
        if(array.length < 2){
            return;
        }
        
        var middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        for(int i=0; i<middle; i++){
            left[i] = array[i];
        }
        for(int i=middle; i<array.length; i++){
            right[i-middle] = array[i];
        }

        Sort(left);
        Sort(right);
        merge(left, right, array);
    }

    public void merge(int[] left, int[] right, int[] result){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length && k < result.length){
            if(left[i] < right[j]){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }
        while(i < left.length){
            result[k++] = left[i++];
        }
        while(j < right.length){
            result[k++] = right[j++];
        }
    }

}
