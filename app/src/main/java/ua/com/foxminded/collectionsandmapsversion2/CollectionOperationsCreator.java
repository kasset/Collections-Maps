package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface CollectionOperationsCreator extends OperationsCreator {
    ArrayList<AbstractOperation> buildArrayListOperations();

    ArrayList<AbstractOperation> buildLinkedListOperations();

    ArrayList<AbstractOperation> buildCopyOnWriteArrayListOperations();
}
