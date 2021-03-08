package ua.com.foxminded.collectionsandmapsversion2;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface OperationsCreator {
    ArrayList<AbstractOperation> createFillingOperations(int size);
    ArrayList<AbstractOperation> createMicroOperations(int idOperation);
}