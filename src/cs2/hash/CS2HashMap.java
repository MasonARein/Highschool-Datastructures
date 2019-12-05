package cs2.hash;

import java.util.*;

public class CS2HashMap <K extends Comparable<K>, V> {
    private ArrayList<TreeMap<K, V>> store;
    private int size;
    private int range;
    public CS2HashMap(int amount){
        range = amount;
        size = 0;
        store = new ArrayList<>();
        for(int c = 0; c < (int)(amount * 1.3); c++){
            store.add(c, new TreeMap<>());
        }
    }
    public void clear(){
        for(TreeMap<K, V> e: store){
            e.clear();
        }
        size = 0;
    }
    public int size(){
        return size;
    }
    public V get(K key){
        int tra = Math.abs(key.hashCode()) % range;
        return store.get(tra).get(key);
    }
    public V put(K key, V value){
        int tra = Math.abs(key.hashCode()) % range;
        if(store.get(tra).put(key, value) == null)
            size++;
        return store.get(tra).put(key, value);
    }
    public String toString(){
        String str = "";
        str += "{";
        for(TreeMap<K, V> a: store){
            str+= a.toString().substring(1, a.toString().length()-1);
            if(!store.get(store.size()-1).equals(a))
            str += ", ";
        }
        str+="}";
        return str;
    }
    public boolean containsKey(K key){
        for(TreeMap<K, V> e: store){
            if(e.containsKey(key)){
                return true;
            }
        }
        return false;
    }
    public boolean containsValue(V value){
        for(TreeMap<K, V> e: store){
            if(e.containsValue(value)){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }
    public Set<K> keySet(){
        Set<K> keys = new HashSet<>();
        for(TreeMap<K, V> e: store){
            for(K a: e.keySet()){
                keys.add(a);
            }
        }
        return keys;
    }
    public V remove(K key){
        for(TreeMap<K, V> e: store){
            if(e.containsKey(key)){
                size--;
                return e.remove(key);
            }
        }
        return null;
    }
    public Collection<V> values(){
        Collection<V> vals = new HashSet<>();
        for(TreeMap<K, V> e: store){
            for(V a: e.values()){
                vals.add(a);
            }
        }
        return vals;
    }

}
