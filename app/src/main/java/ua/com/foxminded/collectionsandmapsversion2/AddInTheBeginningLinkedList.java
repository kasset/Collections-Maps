package ua.com.foxminded.collectionsandmapsversion2;

import java.util.LinkedList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddInTheBeginningLinkedList extends AbstractMicroOperation<LinkedList<Integer>> {
    public AddInTheBeginningLinkedList(LinkedList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_ADD_IN_THE_BEGINNING_LINKED_LIST);
    }
    @Override
    protected void operation(LinkedList<Integer> dataStructure) {
        dataStructure.add(0, 1);
    }
}
