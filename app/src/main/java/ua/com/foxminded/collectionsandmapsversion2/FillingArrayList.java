package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractFillingOperation;

public class FillingArrayList extends AbstractFillingOperation<ArrayList<Integer>> {

    public FillingArrayList(ArrayList<Integer> integers, int size) {
        super(integers, size, Keys.COLLECTION, Keys.ID_ARRAY_LIST);
    }

    @Override
    protected void operation(ArrayList<Integer> dataStructure) {
        for (int i = 0; i < size; i++) {
            dataStructure.add(i);
        }
    }
}
