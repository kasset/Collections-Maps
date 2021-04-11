package ua.com.foxminded.collectionsandmapsversion2.view;

import android.content.Context;
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
import java.util.Map;

import dagger.android.support.AndroidSupportInjection;
import ua.com.foxminded.collectionsandmapsversion2.BaseRecyclerViewAdapter;
import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.ListOfCollectionsOperation;
import ua.com.foxminded.collectionsandmapsversion2.databinding.FragmentCollectionBinding;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;


public class CollectionFragment extends BaseFragment<CollectionsPresenter> {

    private CollectionsPresenter collectionsPresenter;
    private FragmentCollectionBinding binding;
    private int numberOfColumns = 7;
    private ListOfCollectionsOperation listOfCollectionsOperation = new ListOfCollectionsOperation();

    public CollectionFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        collectionsPresenter = (CollectionsPresenter) presenterFactory.get(getPresenterClass());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        for (int i = 0; i < 21; i++) {
            listOfResultsOperations.add(new CalculatedOperation(0, false));
        }
        binding = FragmentCollectionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RecyclerView recyclerViewCollections = binding.recyclerViewCollections;
        recyclerViewCollections.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), numberOfColumns);
        recyclerViewCollections.setLayoutManager(layoutManager);
        recyclerViewCollections.setAdapter(recyclerViewAdapter);
        collectionsPresenter.attachView(this);
        return view;
    }

    @Override
    public Class<CollectionsPresenter> getPresenterClass() {
        return CollectionsPresenter.class;
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
