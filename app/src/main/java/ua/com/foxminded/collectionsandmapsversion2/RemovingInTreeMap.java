package ua.com.foxminded.collectionsandmapsversion2;

import java.util.TreeMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemovingInTreeMap extends AbstractMicroOperation<TreeMap<Integer, String>> {
    public RemovingInTreeMap(TreeMap<Integer, String> integerStringTreeMap) {
        super(integerStringTreeMap, Keys.MAP, Keys.ID_REMOVING_IN_TREE_MAP);
    }

    @Override
    protected void operation(TreeMap<Integer, String> dataStructure) {
        dataStructure.remove(200000);
    }
}
