package ua.com.foxminded.collectionsandmapsversion2;

import java.util.HashMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemovingInHashMap extends AbstractMicroOperation<HashMap<Integer, String>> {

    public RemovingInHashMap(HashMap<Integer, String> integerStringHashMap) {
        super(integerStringHashMap, Keys.MAP, Keys.ID_REMOVING_IN_HASH_MAP);
    }

    @Override
    protected void operation(HashMap<Integer, String> dataStructure) {
        dataStructure.remove(200000);
    }
}
