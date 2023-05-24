public class BinarySearch {

    // BinarySearch ls = new BinarySearch();
    //     int[] array = {1,2,3,4,5};
    //     var x = ls.search(array, 55);
    //     System.out.println(x);
    //---------***---------//

    public int search(int[] array, int target){
        return search(array, target, 0, array.length - 1);
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
