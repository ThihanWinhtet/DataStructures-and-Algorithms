import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Source;

public class TwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> list = new ArrayList<>();
        for(var arr : matrix){
            System.out.println(Arrays.toString(arr));
            for(var ar : arr){
                list.add(ar);
            }
        }
        return list.contains(target);
    }
}
