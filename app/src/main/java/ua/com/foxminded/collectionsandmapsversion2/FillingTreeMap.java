package ua.com.foxminded.collectionsandmapsversion2;

import java.util.TreeMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractFillingOperation;

public class FillingTreeMap extends AbstractFillingOperation<TreeMap<Integer, String>> {

    public FillingTreeMap(TreeMap<Integer, String> integerStringTreeMap, int size) {
        super(integerStringTreeMap, size, Keys.MAP, Keys.ID_TREE_MAP);
    }

    @Override
    protected void operation(TreeMap<Integer, String> dataStructure) {
        for (int i = 0; i < size; i++) {
            dataStructure.put(i, "TreeMap " + i);
        }
    }
}
