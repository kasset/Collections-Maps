package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemoveInTheBeginningArrayList extends AbstractMicroOperation<ArrayList<Integer>> {
    public RemoveInTheBeginningArrayList(ArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_REMOVE_IN_THE_BEGINNING_ARRAY_LIST);
    }
    @Override
    protected void operation(ArrayList<Integer> dataStructure) {
        dataStructure.remove(0);
    }
}
