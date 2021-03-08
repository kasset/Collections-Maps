package ua.com.foxminded.collectionsandmapsversion2;

import java.util.LinkedList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractMicroOperation;

public class RemoveInTheEndLinkedList extends AbstractMicroOperation<LinkedList<Integer>> {
    public RemoveInTheEndLinkedList(LinkedList<Integer> integers) {
        super(integers, Keys.COLLECTION, Keys.ID_REMOVE_IN_THE_END_LINKED_LIST);
    }
    @Override
    protected void operation(LinkedList<Integer> dataStructure) {
        dataStructure.remove(dataStructure.size() - 1);
    }
}
