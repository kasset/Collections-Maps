package ua.com.foxminded.collectionsandmapsversion2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import ua.com.foxminded.collectionsandmapsversion2.CollectionOperationsCreator;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public interface Model {
    Observable<HashMap<Integer, Map<Integer, Integer>>> setOperation(List<AbstractOperation> fillingOperations,
                            HashMap<Integer, List<AbstractOperation>> microOperations);

    HashMap restoreResults();
}
