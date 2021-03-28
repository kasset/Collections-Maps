package ua.com.foxminded.collectionsandmapsversion2;


import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import dagger.android.support.DaggerAppCompatActivity;
import ua.com.foxminded.collectionsandmapsversion2.databinding.ActivityMainBinding;
import ua.com.foxminded.collectionsandmapsversion2.view.CollectionFragment;
import ua.com.foxminded.collectionsandmapsversion2.view.MapFragment;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;


public class MainActivity extends DaggerAppCompatActivity {
    private ViewPager pager;
    private ActivityMainBinding binding;
    private SectionPagerAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        CollectionFragment collectionFragment = new CollectionFragment();
        MapFragment mapFragment = new MapFragment();
        List<FragmentHolder> fragmentsList = new ArrayList<FragmentHolder>() {{
            add(new FragmentHolder(collectionFragment, Keys.COLLECTION, "Collections"));
            add(new FragmentHolder(mapFragment, Keys.MAP, "Maps"));
        }};
        adapter = new SectionPagerAdapter(getSupportFragmentManager(),
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentsList);
        pager = binding.pager;
        binding.pager.setAdapter(adapter);
        binding.tabs.setupWithViewPager(pager);
        binding.calculateButton.setOnClickListener(v -> {
            if (!binding.sizeOfCollectionEditText.getText().toString().isEmpty()) {
                fragmentsList.forEach(baseFragment ->
                        baseFragment.getFragment().sendSize(Integer.parseInt(binding.sizeOfCollectionEditText.getText().toString())));
                }
        });
    }

}