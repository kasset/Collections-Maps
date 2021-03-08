package ua.com.foxminded.collectionsandmapsversion2;

import java.util.HashMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class SearchByKeyInHashMap extends AbstractMicroOperation<HashMap<Integer, String>> {

    public SearchByKeyInHashMap(HashMap<Integer, String> integerStringHashMap) {
        super(integerStringHashMap, Keys.MAP, Keys.ID_SEARCH_BY_KEY_HASH_MAP);
    }

    @Override
    protected void operation(HashMap<Integer, String> dataStructure) {
        dataStructure.get(200000);
    }
}
