public class LinearSearch {
    public int search(int[] array,int target){

    // LinearSearch ls = new LinearSearch();
    // int[] array = {1,2,3,4,5};
    // var x = ls.search(array, 55);
    // System.out.println(x);
    //---------***---------//

        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }
}
