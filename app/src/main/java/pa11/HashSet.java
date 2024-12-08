package pa11;
import java.util.LinkedList;

public class HashSet {
    private int capacity = 13;
    private int size = 0;
    LinkedList<String>[] setList;

    @SuppressWarnings("unchecked")
    public HashSet() {
        System.out.println("HashSet");
        setList = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            setList[i] = new LinkedList<>();
        }
    }

    public int size() {
        System.out.println("Size is " + this.size);
        return this.size;
    }

    public boolean isEmpty() {
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

    public void add(String s) {
        System.out.println("Adding " + s);
        if (s == null) return;
        
        int listNum = hashingAlgorithm(s);
        
        if (contains(s)) return;
        
        setList[listNum].add(s);
        size++;
    }

    public void remove(String s) {
        System.out.println("Removing " + s);
        if (s == null) return;

        int listNum = hashingAlgorithm(s);
        
        if (setList[listNum].remove(s)) {
            size--;
        }
    }

    public boolean contains(String s) {
        System.out.println("Contains " + s);
        if (s == null) return false;

        int listNum = hashingAlgorithm(s);
        return setList[listNum].contains(s);
    }

    public void clear() {
        System.out.println("Clear");
        for (int i = 0; i < capacity; i++) {
            setList[i].clear();
        }
        size = 0;
    }

    public String[] toArray() {
        String[] arr = new String[size];
        int index = 0;
        for (int i = 0; i < capacity; i++) {
            for (String s : setList[i]) {
                arr[index++] = s;
            }
        }
        return arr;
    }

    public HashSet intersection(HashSet other) {
        if (other == null) return new HashSet();
        
        HashSet result = new HashSet();
        for (int i = 0; i < capacity; i++) {
            for (String s : setList[i]) {
                if (other.contains(s)) {
                    result.add(s);
                }
            }
        }
        return result;
    }

    public HashSet union(HashSet other) {
        HashSet result = new HashSet();
        
        for (int i = 0; i < capacity; i++) {
            for (String s : setList[i]) {
                result.add(s);
            }
        }
        
        if (other != null) {
            String[] otherElements = other.toArray();
            for (String s : otherElements) {
                result.add(s);
            }
        }
        
        return result;
    }

    public HashSet difference(HashSet other) {
        HashSet result = new HashSet();
        
        for (int i = 0; i < capacity; i++) {
            for (String s : setList[i]) {
                if (other == null || !other.contains(s)) {
                    result.add(s);
                }
            }
        }
        
        return result;
    }

    public boolean subset(HashSet other) {
        if (other == null) return false;
        
        for (int i = 0; i < capacity; i++) {
            for (String s : setList[i]) {
                if (!other.contains(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}