package ua.com.foxminded.collectionsandmapsversion2;

import java.util.HashMap;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddingNewInHashMap extends AbstractMicroOperation<HashMap<Integer, String>> {

    public AddingNewInHashMap(HashMap<Integer, String> integerStringHashMap) {
        super(integerStringHashMap, Keys.MAP, Keys.ID_NEW_HASH_MAP);
    }

    @Override
    protected void operation(HashMap<Integer, String> dataStructure) {

        dataStructure.put(200000, "Foxminded");
    }
}
