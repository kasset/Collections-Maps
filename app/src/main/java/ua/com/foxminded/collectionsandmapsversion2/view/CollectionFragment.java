package ua.com.foxminded.collectionsandmapsversion2.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.Keys;
import ua.com.foxminded.collectionsandmapsversion2.databinding.FragmentCollectionBinding;
import ua.com.foxminded.collectionsandmapsversion2.presenter.CollectionsPresenter;


public class CollectionFragment extends BaseFragment<CollectionsPresenter, FragmentCollectionBinding> {

    private int numberOfColumns = 7;

    public CollectionFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < 21; i++) {
            listOfResultsOperations.add(new CalculatedOperation(0, false));
        }
        RecyclerView recyclerViewCollections = binding.recyclerViewCollections;
        recyclerViewCollections.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), numberOfColumns);
        recyclerViewCollections.setLayoutManager(layoutManager);
        recyclerViewCollections.setAdapter(recyclerViewAdapter);
    }

    @Override
    public FragmentCollectionBinding getBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentCollectionBinding.inflate(inflater, container, false);
    }

    @Override
    public int getFragmentKey() {
        return Keys.COLLECTION;
    }

    @Override
    public Class<?> getPresenterClass() {
        return CollectionsPresenter.class;
    }


}
