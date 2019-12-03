package cs2.hash;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CS2HashMap <K extends Comparable<K>, V> {
    private ArrayList<TreeMap<K, V>> store = new ArrayList<>();
    private int size;
    private int range;
    public CS2HashMap(int amount){
        range = amount;
        size = 0;
    }
    public void clear(){
        for(TreeMap<K, V> e: store){
            e.clear();
        }
    }
    public int size(){
        return size;
    }
    public V get(K key){
        int tra = key.hashCode() % range;
        return store.get(tra).get(key);
    }
    public V put(K key, V value){
        int tra = key.hashCode() % range;
        return store.get(tra).put(key, value);
    }
    public String toString(){
        String str = "";
        str += "{";
        for(TreeMap<K, V> a: store){
            str+= a.toString().substring(1, a.toString().length()-1);
            str += ", ";
        }
        str+="}";
        return str;
    }
    public boolean containsKey(K key){

    }
    public boolean containsValue(V value){

    }
    public boolean isEmpty(){

    }
    public Set<K> keySet(){

    }
    public V remove(K key){

    }
    public Collection<V> values(){

    }

}
