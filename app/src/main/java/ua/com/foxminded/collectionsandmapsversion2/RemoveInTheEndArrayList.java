package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemoveInTheEndArrayList extends AbstractMicroOperation<ArrayList<Integer>> {
    public RemoveInTheEndArrayList(ArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_REMOVE_IN_THE_END_ARRAY_LIST);
    }
    @Override
    protected void operation(ArrayList<Integer> dataStructure) {
        dataStructure.remove(dataStructure.size() - 1);
    }
}
