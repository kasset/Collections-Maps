package ua.com.foxminded.collectionsandmapsversion2;

import java.util.TreeMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class SearchByKeyInTreeMap extends AbstractMicroOperation<TreeMap<Integer, String>> {
    public SearchByKeyInTreeMap(TreeMap<Integer, String> integerStringTreeMap) {
        super(integerStringTreeMap, Keys.MAP, Keys.ID_SEARCH_BY_KEY_TREE_MAP);
    }

    @Override
    protected void operation(TreeMap<Integer, String> dataStructure) {
        dataStructure.get(200000);
    }
}
