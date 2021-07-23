package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddInTheEndOfArrayList extends AbstractMicroOperation<ArrayList<Integer>> {
    public AddInTheEndOfArrayList(ArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_ADD_IN_THE_END_ARRAY_LIST);
    }
    @Override
    protected void operation(ArrayList<Integer> dataStructure) {
        dataStructure.add(dataStructure.size() - 1, 1);
    }
}
