package ua.com.foxminded.collectionsandmapsversion2.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dagger.android.support.AndroidSupportInjection;
import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.ListOfMapsOperation;
import ua.com.foxminded.collectionsandmapsversion2.databinding.FragmentMapBinding;
import ua.com.foxminded.collectionsandmapsversion2.presenter.MapsPresenter;

public class MapFragment extends BaseFragment<MapsPresenter> {

    private MapsPresenter mapsPresenter;
    private FragmentMapBinding binding;
    private int numberOfColumns = 3;
    private ListOfMapsOperation listOfMapsOperation = new ListOfMapsOperation();

    public MapFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        mapsPresenter = (MapsPresenter) presenterFactory.get(getPresenterClass());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        for (int i = 0; i < 6; i++) {
            listOfResultsOperations.add(new CalculatedOperation(0, false));
        }
        binding = FragmentMapBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RecyclerView recyclerViewMap = binding.recyclerViewMap;
        recyclerViewMap.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), numberOfColumns);
        recyclerViewMap.setLayoutManager(layoutManager);
        recyclerViewMap.setAdapter(recyclerViewAdapter);
        mapsPresenter.attachView(this);
        return view;
    }

    @Override
    public Class<MapsPresenter> getPresenterClass() {
        return MapsPresenter.class;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void sendSize(int size) {
        mapsPresenter.initiateCalculation(size);
    }

}



