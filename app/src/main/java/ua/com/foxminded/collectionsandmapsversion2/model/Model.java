package ua.com.foxminded.collectionsandmapsversion2.model;

import java.util.HashMap;
import java.util.List;

import ua.com.foxminded.collectionsandmapsversion2.CollectionOperationsCreator;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface Model {
    void setOperation(List<AbstractOperation> fillingOperations, HashMap<Integer, List<AbstractOperation>> microOperations);

    HashMap restoreResults();
}
