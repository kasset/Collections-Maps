package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemoveInTheMiddleArrayList extends AbstractMicroOperation<ArrayList<Integer>> {
    public RemoveInTheMiddleArrayList(ArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_REMOVE_IN_THE_MIDDLE_ARRAY_LIST);
    }
    @Override
    protected void operation(ArrayList<Integer> dataStructure) {
        dataStructure.remove(dataStructure.size() / 2);
    }
}
