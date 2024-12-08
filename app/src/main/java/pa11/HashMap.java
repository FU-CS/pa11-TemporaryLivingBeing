package pa11;
import java.util.LinkedList;

public class HashMap {
    public class Tuple<first, second> {
        private String key;
        private String value;
    
        public Tuple(String first, String second) {
            this.key = first;
            this.value = second;
        }
    
        public String getKey() {
            return this.key;
        }
    
        public String getValue() {
            return this.value;
        }

        public void editValue(String newValue) {
            this.value = newValue;
        }
    }

    private int capacity = 13;
    private int size = 0;

    @SuppressWarnings("rawtypes")
    LinkedList<Tuple>[] setList;

    @SuppressWarnings("unchecked")
    public HashMap() {
        System.out.println("HashMap");
        setList = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            setList[i] = new LinkedList<>();
        }
    }
    
    public int size() {
        System.out.println("Size");
        return this.size;
    }

    public boolean isEmpty() {
        System.out.println("IsEmpty");
        return this.size == 0;
    }

    private int hashingAlgorithm(String s) {
        System.out.println("Hashing " + s);
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c;
            value += ascii; 
        }
        return value % capacity;
    }

    @SuppressWarnings("unchecked")
    public String get(String key) {
        System.out.println("Get " + key);
        if (key == null) return null;
        
        int listNum = hashingAlgorithm(key);
        
        for (Tuple<String, String> tuple : setList[listNum]) {
            if (key.equals(tuple.getKey())) {
                return tuple.getValue();
            }
        }
        
        return null;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public String put(String key, String value) {
        System.out.println("Put " + key + " " + value);
        if (key == null) return null;
        
        int listNum = hashingAlgorithm(key);
        
        for (Tuple tuple : setList[listNum]) {
            if (key.equals(tuple.getKey())) {
                String oldValue = tuple.getValue();
                tuple.editValue(value);
                return oldValue;
            }
        }
        
        setList[listNum].add(new Tuple<>(key, value));
        size++;
        return null;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public String remove(String key) {
        System.out.println("Remove " + key);
        if (key == null) return null;

        int listNum = hashingAlgorithm(key);
        
        LinkedList<Tuple> list = setList[listNum];
        for (int i = 0; i < list.size(); i++) {
            if (key.equals(list.get(i).getKey())) {
                String oldValue = list.get(i).getValue();
                list.remove(i);
                size--;
                return oldValue;
            }
        }
        
        return null;
    }

    @SuppressWarnings("rawtypes")
    public String[] keySet() {
        System.out.println("KeySet");
        String[] keys = new String[size];
        int index = 0;
        
        for (LinkedList<Tuple> list : setList) {
            for (Tuple tuple : list) {
                keys[index++] = tuple.getKey();
            }
        }
        
        return keys;
    }

    @SuppressWarnings("rawtypes")
    public String[] values() {
        System.out.println("Values");
        String[] values = new String[size];
        int index = 0;
        
        for (LinkedList<Tuple> list : setList) {
            for (Tuple tuple : list) {
                values[index++] = tuple.getValue();
            }
        }
        
        return values;
    }
}