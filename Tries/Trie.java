import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node{
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
    }

    private Node root = new Node(' ');
    
    public void insert(String word){
        var current= root;
       for(char ch : word.toCharArray()){
        if(current.children.get(ch) == null ){
            current.children.put(ch, new Node(ch));
        }
        current = current.children.get(ch);
        current.isEndOfWord = true;
       }
    }

    public boolean contains(String word){
        var current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        System.out.println(root.value);

        for(var child : root.getChildren()){
            traverse(child);
        }
    }

    public void remove(String word){
        if(word == null){
            return;
        }
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.children.get(ch);
        if(child == null){
            return;
        }
        remove(child, word, index + 1);

        if(child.getChildren().length == 0 && !child.isEndOfWord){
            root.children.remove(ch);
        }
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = findLastCh(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> word){
        if(root.isEndOfWord){
            word.add(prefix);
        }
        for(var child : root.getChildren()){
            findWords(child, prefix + child.value, word);
        }
    }
 
    private Node findLastCh(String prefix){
        var current = root;
        for(char ch : prefix.toCharArray()){
            var child = current.children.get(ch);
            if(child == null)
                return null;
            current = child;
        }
        return current;
    }


}
