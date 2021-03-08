package ua.com.foxminded.collectionsandmapsversion2;

import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemoveInTheEndCopyOnWriteArrayList extends AbstractMicroOperation<CopyOnWriteArrayList<Integer>> {
    public RemoveInTheEndCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_REMOVE_IN_THE_END_COPY_ON_WRITE_ARRAY_LIST);
    }
    @Override
    protected void operation(CopyOnWriteArrayList<Integer> dataStructure) {
        dataStructure.remove(dataStructure.size() - 1);
    }
}
