package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ua.com.foxminded.collectionsandmapsversion2.Keys;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class Storage implements Model {

    private HashMap<Integer, Map<Integer, Integer>> operationResults = new HashMap<>();
    private Disposable disposable;


    @Inject
    public Storage() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setOperation(List<AbstractOperation> fillingOperations, HashMap<Integer, List<AbstractOperation>> microOperations) {
        disposable = Observable.fromIterable(fillingOperations)
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
                            });
                    return Observable.just(AbstractOperation);
                })
                .subscribe(AbstractOperation::run);
    }


    @Override
    public HashMap restoreResults() {
        return operationResults;
    }


}
