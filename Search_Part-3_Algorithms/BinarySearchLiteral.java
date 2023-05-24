public class BinarySearchLiteral {

    // BinarySearchLiteral ls = new BinarySearchLiteral();
    //     int[] array = {1,2,3,4,5};
    //     var x = ls.search(array, 55);
    //     System.out.println(x);
    //---------***---------//

    public int search(int[] array, int target){
        int left = 0, right = array.length - 1;
        while(left <= right){
            var middle = (left + right) / 2;
            if(array[middle] == target){
                System.out.println(middle);
            }
            if(target < array[middle]){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }
}
