public class exponentialSearch {
    public int search(int[] array , int target) {
        var bound = 1;
        while(bound < array.length && array[bound] < target){
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return search(array, target, left, right);
    }
    private int search(int[] array, int target, int left, int right){
        if(right < left){
            return -1;
        }
        
        var middle = (left + right) / 2;

        if(array[middle] == target){
            return middle;
        }
        if(array[middle] > target){
            return search(array, target, left, middle - 1);
        }

        return search(array, target, middle + 1, right );
    }
}
