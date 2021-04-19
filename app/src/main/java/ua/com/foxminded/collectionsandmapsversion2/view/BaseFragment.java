package ua.com.foxminded.collectionsandmapsversion2.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import ua.com.foxminded.collectionsandmapsversion2.BaseRecyclerViewAdapter;
import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.SizeProvider;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.PresenterFactory;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

public abstract class BaseFragment<T extends BasePresenter, E extends ViewBinding> extends Fragment implements SizeProvider {

    @Inject
    PresenterFactory presenterFactory;

    protected ArrayList<CalculatedOperation> listOfResultsOperations = new ArrayList<>();
    protected BaseRecyclerViewAdapter recyclerViewAdapter = new BaseRecyclerViewAdapter(listOfResultsOperations);
    protected T basePresenter;
    protected E binding;

    public BaseFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        basePresenter = (T) presenterFactory.get(getPresenterClass());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = getBinding(inflater, container);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        basePresenter.attachView(this);
        getResults();
    }

    @Override
    public void sendSize(int size) {
        basePresenter.initiateCalculation(size);
    }

    public void showInitiateCalculating() {
        for (int i = 0; i < listOfResultsOperations.size(); i++) {
            recyclerViewAdapter.updateOperationResult(i, 0, true);
        }
    }

    public void getResults() {
        basePresenter.getResult(getFragmentKey());
    }

    public void publishOperationResult(int itemId, int result) {
        recyclerViewAdapter.updateOperationResult(itemId, result, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        basePresenter.detachView();
        binding = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        basePresenter = null;
    }

    public abstract E getBinding(LayoutInflater inflater, ViewGroup container);

    public abstract int getFragmentKey();

    public abstract Class<?> getPresenterClass();

}
