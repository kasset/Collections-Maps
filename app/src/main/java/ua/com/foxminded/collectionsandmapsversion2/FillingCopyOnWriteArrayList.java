package ua.com.foxminded.collectionsandmapsversion2;

import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractFillingOperation;

public class FillingCopyOnWriteArrayList extends AbstractFillingOperation<CopyOnWriteArrayList<Integer>> {

    public FillingCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> integers, int size) {
        super(integers, size, Keys.COLLECTION, Keys.ID_COPY_ON_WRITE_ARRAY_LIST);
    }

    @Override
    protected void operation(CopyOnWriteArrayList<Integer> dataStructure) {
        for (int i = 0; i < size; i++) {
            dataStructure.add(i);
        }
    }
}
