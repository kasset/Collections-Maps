package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddInTheBeginningArrayList extends AbstractMicroOperation<ArrayList<Integer>> {
    public AddInTheBeginningArrayList(ArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_ADD_IN_THE_BEGINNING_ARRAY_LIST);
    }
    @Override
    protected void operation(ArrayList<Integer> dataStructure) {
        dataStructure.add(0, 1);
    }
}
