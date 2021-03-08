package ua.com.foxminded.collectionsandmapsversion2;

import java.util.HashMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractFillingOperation;

public class FillingHashMap extends AbstractFillingOperation<HashMap<Integer, String>> {

    public FillingHashMap(HashMap<Integer, String> integerStringHashMap, int size) {
        super(integerStringHashMap, size, Keys.MAP, Keys.ID_HASH_MAP);
    }

    @Override
    protected void operation(HashMap<Integer, String> dataStructure) {
        for (int i = 0; i < size; i++) {
            dataStructure.put(i, "HashMap " + i);
        }
    }
}
