import java.util.Objects;

/**
 * Created by Abdellatif on 9/28/2016.
 */
public class HashMap {
    private String[] keys;
    private Object[] values;
    //the size of the HashMap
    private int size;
    //the number of items in the Hashmap
    private int items = 0;

    //Construct a Hashmap from a given size
    public HashMap(int size){
        keys = new String[size];
        values = new Object[size];
    }

    public boolean set(String key, Object value){
        //if the key doesn't exist, generate a new item
        if (findKeyIndex(key) == -1){
            //return an error if the Hashmap is full
            if (items == size){
                return false;
            }
            //add a new key/value pair to the hashmap
            else{
                items++;
                keys[items] = key;
                values[items] = value;
                return true;
            }
        }
        //if the key exists, update it
        else{
            values[findKeyIndex(key)] = value;
            return true;
        }
    }

    /**
     * Checks the index of a given key
     * @param key the key to check
     * @return the index of the key, -1 if it doesn't exist
     */
    private int findKeyIndex(String key){
        for (int i = 0; i < items; i++){
            if (keys[i] == key){
                return i;
            }
        }
        return -1;
    }

    public Object get(String key){
        //return null if the key isn't found
        if (findKeyIndex(key) == -1){
            return null;
        }
        //return the value associated with the given key
        else{
            return values[findKeyIndex(key)];
        }
    }
}
