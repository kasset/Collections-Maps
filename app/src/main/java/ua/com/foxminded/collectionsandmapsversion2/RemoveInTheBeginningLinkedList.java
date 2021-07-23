package ua.com.foxminded.collectionsandmapsversion2;

import java.util.LinkedList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemoveInTheBeginningLinkedList extends AbstractMicroOperation<LinkedList<Integer>> {
    public RemoveInTheBeginningLinkedList(LinkedList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_REMOVE_IN_THE_BEGINNING_LINKED_LIST);
    }
    @Override
    protected void operation(LinkedList<Integer> dataStructure) {
        dataStructure.remove(0);
    }
}
