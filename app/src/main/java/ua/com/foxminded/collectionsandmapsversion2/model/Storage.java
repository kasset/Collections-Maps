package ua.com.foxminded.collectionsandmapsversion2.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import ua.com.foxminded.collectionsandmapsversion2.OperationResult;
import ua.com.foxminded.collectionsandmapsversion2.strategy.AbstractOperation;

public class Storage implements Model {

    private ReplaySubject<OperationResult> subject = ReplaySubject.create();

    @Inject
    public Storage() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void setOperation(List<AbstractOperation> fillingOperations,
                             HashMap<Integer, List<AbstractOperation>> microOperations) {
        Observable.fromIterable(fillingOperations)
                .subscribeOn(Schedulers.computation())
                .flatMap(abstractOperation -> Observable.just(abstractOperation.run()))
                .flatMapIterable(operationResult -> microOperations.get(operationResult.idOperation))
                .doOnNext(microOperation -> subject.onNext(microOperation.run()))
                .subscribe();
    }

    @Override
    public Observable<OperationResult> getOperationResults() {
        return subject;
    }


}
