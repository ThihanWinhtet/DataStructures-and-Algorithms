
import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];   
    
    public void put(int key, String value){
        int index = hash(key);
        if(entries[index]== null){
            entries[index] = new LinkedList<>();
        }
        LinkedList bucket = entries[index];
        for(int entry : bucket){
            if(entry.key == key){
                entry.value = value;
                return;
            }
        }
        var entry = new Entry(key, value);
        entries[index].addLast(entry);
    }

    public int hash(int key){
        return key % entries.length;
    }
}
