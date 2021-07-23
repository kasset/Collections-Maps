package ua.com.foxminded.collectionsandmapsversion2.model;

import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import ua.com.foxminded.collectionsandmapsversion2.OperationResult;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface Model {
    void setOperation(List<AbstractOperation> fillingOperations,
                      HashMap<Integer, List<AbstractOperation>> microOperations);

    Observable<OperationResult> getOperationResults();
}
