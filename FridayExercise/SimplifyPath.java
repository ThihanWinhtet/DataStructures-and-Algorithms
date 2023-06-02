import java.util.ArrayList;
import java.util.List;


/**
 * SimplifyPath
 */
public class SimplifyPath {
        public String simplifyPath(String path) {
            List<Character> list = new ArrayList<>();
            List<Character> list1 = new ArrayList<>();
            String str = "";

            
            for(int i = 0; i < path.length(); i++){
                System.out.print("");
                if(path.charAt(i) != '/'){
                    list.add(path.charAt(i));
                }
                if(i < path.length() - 1 && path.charAt(i) == '/' && path.charAt(i+1) != '/'){
                    list.add(path.charAt(i));
                }
            }
            var list2 = list;
            var dot1 = 0;
            var chu = 0;
            var cc = 1;
            var bol = false;
            System.out.println(list + " s");
            for(int i = 0; i < list.size()-1; i++){
                if(list.get(i) == '.'){
                    dot1 = i;
                    break;
                }
            }
            for(int i = list.size()-1; i >= 0; i--){
                if(list.get(i) != '.' && list.get(i) != '/'){
                    chu = i;
                    break;
                }
            }
            if(dot1 < chu && chu != 0){
                bol = false;
            }else{
                bol = true;
            }
            

            System.out.println(chu);
            if(bol){
                for (int i = list.size() - 1; i >=0;  i--) {
                    if(list.get(i) != '/' && list.get(i) != '.'){
                        list2.remove(i);
                        break;
                    }
                } 
            }
            if(list2.size() == 0){
                return "/";
            }
            int size = list2.size()-1;
            list1 = list2;
            while(list.get(size) == '.' || list.get(size) == '/' && size >= 1){
                list1.remove(size);
                System.out.println(list1 + " " + " " + size);
                size--;
            }
            for(var ch : list1){
                str = str + ch;
            }
            System.out.println(str);

            var dot = 0;
            var count = 1;
            for(var ch : str.toCharArray()){
                if(ch == '.'){
                    dot = count;
                }
                count++;
            }
            str = str.substring(dot, str.length());
            System.out.println(str);
            return str;
        }
}




//     public String simplifyPath(String path) {
//         System.out.println(path);
//         return "1";
//     }







