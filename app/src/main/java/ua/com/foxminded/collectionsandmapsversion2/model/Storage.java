package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class Storage implements Model {

    private ReplaySubject<Map<Integer, Map<Integer, Integer>>> subject = ReplaySubject.create();


    @Inject
    public Storage() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Observable<Map<Integer, Map<Integer, Integer>>> setOperation(List<AbstractOperation> fillingOperations,
                                                          HashMap<Integer, List<AbstractOperation>> microOperations) {
        HashMap<Integer, Map<Integer, Integer>> operationResults = new HashMap<>();
        Observable.fromIterable(fillingOperations)
                .subscribeOn(Schedulers.computation())
                .flatMap(AbstractOperation -> {
                    microOperations.get(AbstractOperation.run().idOperation)
                            .forEach(microOperation -> {
                                int fragmentType = microOperation.run().fragmentType;
                                int idOperation = microOperation.run().idOperation;
                                int durationOfOperation = microOperation.run().duration;
                                if (!operationResults.containsKey(fragmentType)) {
                                    operationResults.put(fragmentType, new HashMap<>());
                                }
                                operationResults.get(fragmentType).put(idOperation, durationOfOperation);
                                subject.onNext(operationResults);

                            });
                    return Observable.just(AbstractOperation);
                })
                .subscribe(AbstractOperation::run);
        return subject;
    }


    @Override
    public HashMap restoreResults() {
        return null;
    }


}
