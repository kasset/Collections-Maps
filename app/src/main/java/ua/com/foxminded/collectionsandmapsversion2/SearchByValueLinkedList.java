package ua.com.foxminded.collectionsandmapsversion2;

import java.util.LinkedList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class SearchByValueLinkedList extends AbstractMicroOperation<LinkedList<Integer>> {
    public SearchByValueLinkedList(LinkedList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_SEARCH_BY_VALUE_LINKED_LIST);
    }
    @Override
    protected void operation(LinkedList<Integer> dataStructure) {
        dataStructure.add(dataStructure.get(dataStructure.indexOf(777)));
    }
}
