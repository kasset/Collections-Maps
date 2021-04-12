package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import ua.com.foxminded.collectionsandmapsversion2.model.Model;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class Storage implements Model {

    private ReplaySubject<Map<Integer, Map<Integer, Integer>>> subject = ReplaySubject.create();
    private HashMap<Integer, Map<Integer, Integer>> operationResults = new HashMap<>();

    @Inject
    public Storage() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Observable<Map<Integer, Map<Integer, Integer>>> setOperation(List<AbstractOperation> fillingOperations,
                                                                        HashMap<Integer, List<AbstractOperation>> microOperations) {
        Observable.fromIterable(fillingOperations)
                .subscribeOn(Schedulers.computation())
                .flatMap(AbstractOperation -> {
                    microOperations.get(AbstractOperation.run().idOperation)
                            .forEach(microOperation -> {
                                int fragmentType = microOperation.run().fragmentType;
                                int idOperation = microOperation.run().idOperation;
                                int durationOfOperation = microOperation.run().duration;
                                subject.onNext(getResultsMap(fragmentType, idOperation, durationOfOperation));
                            });
                    return Observable.just(AbstractOperation);
                })
                .subscribe(AbstractOperation::run);
        return subject;
    }


    @Override
    public HashMap<Integer, Map<Integer, Integer>> restoreResults() {
        return operationResults;
    }

    private Map<Integer, Map<Integer, Integer>> getResultsMap(int fragmentType, int idOperation, int result) {
        if (!operationResults.containsKey(fragmentType)) {
            operationResults.put(fragmentType, new HashMap<>());
        }
        operationResults.get(fragmentType).put(idOperation, result);
        return operationResults;
    }


}
