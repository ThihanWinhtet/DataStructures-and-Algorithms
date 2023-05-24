public class JumpSearch {
    
    public int search(int[] array , int target){
        int block = (int) Math.sqrt(array.length);
        int start = 0;
        int next = block;
        while(target > array[next - 1] && start < array.length){
            start = next;
            next += block;
            if(next > array.length){
                next = array.length;
            }
            for(var i = start; i < next; i++){
                if(target == array[i]){
                    return i;
                }
            }
        }
        return -1;
    }

}
