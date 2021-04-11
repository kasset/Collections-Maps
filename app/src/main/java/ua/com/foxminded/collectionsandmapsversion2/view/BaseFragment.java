package ua.com.foxminded.collectionsandmapsversion2.view;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.BaseRecyclerViewAdapter;
import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.SizeProvider;
import ua.com.foxminded.collectionsandmapsversion2.databinding.FragmentCollectionBinding;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.PresenterFactory;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

public abstract class BaseFragment<T> extends Fragment implements SizeProvider {

    @Inject
    PresenterFactory presenterFactory;

    protected ArrayList<CalculatedOperation> listOfResultsOperations = new ArrayList<>();
    protected BaseRecyclerViewAdapter recyclerViewAdapter = new BaseRecyclerViewAdapter(listOfResultsOperations);

    public BaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void sendSize(int size) {
    }

    public void showInitiateCalculating() {
        for (int i = 0; i < listOfResultsOperations.size(); i++) {
            recyclerViewAdapter.updateOperationResult(i, 0, true);
        }
    }

    public void publishOperationResult(Map<Integer, Integer> operationResults) {
        for (int i = 0; i < operationResults.size(); i++) {
            recyclerViewAdapter.updateOperationResult(i, operationResults.get(i), false);
        }
    }

    public abstract Class<T> getPresenterClass();
}
