package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StorageCollectionsAndMaps {
    private static StorageCollectionsAndMaps storageCollectionsAndMaps;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private HashMap<Integer, String> hashMap = new HashMap<>();
    private TreeMap<Integer, String> treeMap = new TreeMap<>();

    private StorageCollectionsAndMaps() {
    }

    public static StorageCollectionsAndMaps getInstance(){
            if(storageCollectionsAndMaps == null) {
                storageCollectionsAndMaps = new StorageCollectionsAndMaps();
            }
            return storageCollectionsAndMaps;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public CopyOnWriteArrayList<Integer> getCopyOnWriteArrayList() {
        return copyOnWriteArrayList;
    }

    public HashMap<Integer, String> getHashMap() {
        return hashMap;
    }

    public TreeMap<Integer, String> getTreeMap() {
        return treeMap;
    }
}