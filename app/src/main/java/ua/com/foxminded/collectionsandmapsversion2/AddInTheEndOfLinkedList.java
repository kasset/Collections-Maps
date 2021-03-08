package ua.com.foxminded.collectionsandmapsversion2;

import java.util.LinkedList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class AddInTheEndOfLinkedList extends AbstractMicroOperation<LinkedList<Integer>> {
    public AddInTheEndOfLinkedList(LinkedList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_ADD_IN_THE_END_LINKED_LIST);
    }

    @Override
    protected void operation(LinkedList<Integer> dataStructure) {
        dataStructure.add(dataStructure.size() - 1, 777);
    }
}
