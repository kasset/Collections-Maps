package ua.com.foxminded.collectionsandmapsversion2;

import java.util.TreeMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddingNewInTreeMap extends AbstractMicroOperation<TreeMap<Integer, String>> {

    public AddingNewInTreeMap(TreeMap<Integer, String> integerStringTreeMap) {
        super(integerStringTreeMap, Keys.MAP, Keys.ID_NEW_TREE_MAP);
    }

    @Override
    protected void operation(TreeMap<Integer, String> dataStructure) {
        dataStructure.put(200000, "Foxminded");
    }
}
