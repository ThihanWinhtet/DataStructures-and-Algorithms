public class MaxHeap {
    public static void heapify(int[] array){
        for(int i=0; i< array.length; i++){
            heapify(array,i);
        }
    }
    private static void heapify(int[] array, int index){
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        var rightIndex = index * 2 + 2;
        if(leftIndex < array.length && array[leftIndex] > array[largerIndex]){
            largerIndex = leftIndex;
        }
        if(rightIndex < array.length && array[rightIndex] > array[largerIndex]){
            largerIndex = rightIndex;
        }

        if(index == largerIndex){
            return;
        }

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public static void swap(int[] array, int first, int sec){

        var tempo = array[first];
        array[first] = array[sec];
        array[sec] = tempo;
    }

    public static int kth(int[] array, int kth){
        Heap heap = new Heap();
        for(var items : array){
            heap.insert(items);
        }
        for(int i =0 ; i < kth -1 ; i++){
            heap.remove();
        }

        return heap.max();
    }

}
