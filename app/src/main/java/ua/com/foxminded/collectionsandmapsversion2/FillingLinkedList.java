package ua.com.foxminded.collectionsandmapsversion2;

import java.util.LinkedList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractFillingOperation;

public class FillingLinkedList extends AbstractFillingOperation<LinkedList<Integer>> {
    public FillingLinkedList(LinkedList<Integer> integers, int size) {
        super(integers, size, Keys.COLLECTION, Keys.ID_LINKED_LIST);
    }

    @Override
    protected void operation(LinkedList<Integer> dataStructure) {
        for (int i = 0; i < size; i++) {
            dataStructure.add(i);
        }
    }
}
