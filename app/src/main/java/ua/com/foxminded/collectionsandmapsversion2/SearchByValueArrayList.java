package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class SearchByValueArrayList extends AbstractMicroOperation<ArrayList<Integer>> {
    public SearchByValueArrayList(ArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_SEARCH_BY_VALUE_ARRAY_LIST);
    }
    @Override
    protected void operation(ArrayList<Integer> dataStructure) {

        dataStructure.add(dataStructure.get(dataStructure.indexOf(333)));
    }
}
