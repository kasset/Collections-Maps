package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface OperationsCreator {
    ArrayList<AbstractOperation> createFillingOperations(int size);
    HashMap<Integer, List<AbstractOperation>> createMicroOperations();

}