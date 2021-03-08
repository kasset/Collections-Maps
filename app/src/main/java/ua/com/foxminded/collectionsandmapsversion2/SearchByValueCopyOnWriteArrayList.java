package ua.com.foxminded.collectionsandmapsversion2;

import java.util.concurrent.CopyOnWriteArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class SearchByValueCopyOnWriteArrayList extends AbstractMicroOperation<CopyOnWriteArrayList<Integer>> {
    public SearchByValueCopyOnWriteArrayList(CopyOnWriteArrayList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_SEARCH_BY_VALUE_COPY_ON_WRITE_ARRAY_LIST);
    }
    @Override
    protected void operation(CopyOnWriteArrayList<Integer> dataStructure) {
        dataStructure.get(dataStructure.indexOf(888));
    }
}
