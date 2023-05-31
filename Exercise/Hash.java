import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Hash hash = new Hash();
// System.out.println(hash.findingMostRepeating("hell"));
// System.out.println(hash.findingFirstRepeating("ithih"));
// hash.removingDuplicate("hell");


public class Hash {
    public String findingMostRepeating(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(var ch : str.toCharArray()){
            var count = map.get(ch);
            if(map.containsKey(ch)){
                map.put(ch, count+1);
            }else{
                map.put(ch, 1);
            }
        }
        var max = 0;
        var result = "";
        for(var ch : map.keySet()){
            max = Math.max(max, map.get(ch));
            if(map.get(ch) == max){
                result = "" + ch;
            }
        }
        return result;
    }
    
    public Character findingFirstRepeating(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(var ch : str.toCharArray()){
            var count = map.get(ch);
            if(map.containsKey(ch)){
                map.put(ch, count+1);
                return ch;
            }else{
                map.put(ch, 1);
            }
        }
        return Character.MIN_VALUE;
    }

    public Set<Character> removingDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for(var ch : str.toCharArray()){set.add(ch);} return set;
    }
}
