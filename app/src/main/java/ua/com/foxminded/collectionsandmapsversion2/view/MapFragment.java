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

import ua.com.foxminded.collectionsandmapsversion2.BaseFragment;
import ua.com.foxminded.collectionsandmapsversion2.BaseRecyclerViewAdapter;
import ua.com.foxminded.collectionsandmapsversion2.CalculatedOperation;
import ua.com.foxminded.collectionsandmapsversion2.ListOfMapsOperation;
import ua.com.foxminded.collectionsandmapsversion2.databinding.FragmentMapBinding;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BaseContract;

public class MapFragment extends BaseFragment implements BaseContract.BaseView {

    private FragmentMapBinding binding;
    private BaseRecyclerViewAdapter mapAdapter;
    private int numberOfColumns = 3;
    private ArrayList<CalculatedOperation> listOfResultsOperations;
    private ListOfMapsOperation listOfMapsOperation = new ListOfMapsOperation();


    public MapFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        listOfResultsOperations = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            listOfResultsOperations.add(new CalculatedOperation(0, true));
        }
        binding = FragmentMapBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        RecyclerView recyclerViewMap = binding.recyclerViewMap;
        recyclerViewMap.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), numberOfColumns);
        recyclerViewMap.setLayoutManager(layoutManager);
        mapAdapter = new BaseRecyclerViewAdapter(listOfResultsOperations);
        recyclerViewMap.setAdapter(mapAdapter);
        return view;
    }

    @Override
    public void showProgressBar() {
        for (int i = 0; i < listOfResultsOperations.size(); i++) {
            mapAdapter.updateOperationResult(i, 0, true);
        }
    }

    @Override
    public void publishOperationResult(Message message) {
        mapAdapter.updateOperationResult(message.arg1, message.arg2, false);
        mapAdapter.notifyItemChanged(message.arg1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}


