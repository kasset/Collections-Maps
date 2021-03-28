package ua.com.foxminded.collectionsandmapsversion2.view;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.com.foxminded.collectionsandmapsversion2.BaseRecyclerViewAdapter;
import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.databinding.FragmentCollectionBinding;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;


public class CollectionFragment extends BaseFragment {


    CollectionsPresenter collectionsPresenter;
    private FragmentCollectionBinding binding;
    private BaseRecyclerViewAdapter collectionsAdapter;
    private int numberOfColumns = 7;
    private ArrayList<CalculatedOperation> listOfResultsOperations;
    private ListOfCollectionsOperation listOfCollectionsOperation = new ListOfCollectionsOperation();

    public CollectionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        listOfResultsOperations = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            listOfResultsOperations.add(new CalculatedOperation(0, false));
        }
        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RecyclerView recyclerViewCollections = binding.recyclerViewCollections;
        recyclerViewCollections.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), numberOfColumns);
        recyclerViewCollections.setLayoutManager(layoutManager);
        collectionsAdapter = new BaseRecyclerViewAdapter(listOfResultsOperations);
        recyclerViewCollections.setAdapter(collectionsAdapter);
        return view;
    }

    @Override
    public void showInitiateCalculating() {
        for (int i = 0; i < listOfResultsOperations.size(); i++) {
            collectionsAdapter.updateOperationResult(i, 0, true);
        }
    }

    @Override
    public void publishOperationResult(Message message) {
        collectionsAdapter.updateOperationResult(message.arg1, message.arg2, false);
        collectionsAdapter.notifyItemChanged(message.arg1);
    }

    @Override
    protected BasePresenter getPresenter(Class<?> presenterType) {
        return null;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void sendSize(int size) {
        collectionsPresenter.initiateCalculation(size);
    }

}
