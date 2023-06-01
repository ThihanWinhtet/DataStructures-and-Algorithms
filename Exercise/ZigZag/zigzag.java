import java.util.ArrayList;

public class zigzag {
    public String convert(String s, int numRows) {


        // zigzag zz = new zigzag();
        // zz.convert("PAYPALISHIRING", 13);

        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        var so = 1;

        if(numRows <= 1){
            return s;
        }
        
        while(al.size() < s.length()){
            if(so < numRows){
                for(int i = 1; i <= numRows; i++){
                    al.add(i);
                    so = i;
                }
            }
            if(so == numRows){
                for(int i = numRows-1; i >= 1; i--){
                    al.add(i);
                    so = i;
                }
            }
            if(so == 1){
                for(int i = 2; i <= numRows; i++){
                    al.add(i);
                    so = i;
                }
            }
        }
        var size = 0;
        for(var i : s.toCharArray()){
            var res = al.get(size) + " " + i;
            al1.add(res);
            size++;
        }
        var c = 1;
        for(int j = 1; j <= numRows; j++){
            for(var i : al1){
                    String st = i.substring(0, i.length()-1);
                    var y = " " + c + " ";
                if(i.contains(""+ c + " ") && y.contains(st)){
                    var res = i.replace(""+c+" ", "");
                    al2.add(res);
                }
            }
            c++;
        }
        String listString = String.join("", al2);
        System.out.println(listString);
        return listString;
    }
}
