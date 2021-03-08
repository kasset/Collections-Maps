package ua.com.foxminded.collectionsandmapsversion2;

import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddInTheBeginningCopyOnWriteArrayList extends AbstractMicroOperation<CopyOnWriteArrayList<Integer>> {
    public AddInTheBeginningCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_ADD_IN_THE_BEGINNING_COPY_ON_WRITE_ARRAY_LIST);
    }
    @Override
    protected void operation(CopyOnWriteArrayList<Integer> dataStructure) {
        dataStructure.add(0, 1);
    }
}
