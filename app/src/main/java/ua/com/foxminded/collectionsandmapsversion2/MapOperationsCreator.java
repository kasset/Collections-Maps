package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface MapOperationsCreator extends OperationsCreator {
    ArrayList<AbstractOperation> buildHashMapOperations();

    ArrayList<AbstractOperation> buildTreeMapOperations();
}
