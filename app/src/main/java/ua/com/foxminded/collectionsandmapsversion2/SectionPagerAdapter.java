package ua.com.foxminded.collectionsandmapsversion2;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private final List<FragmentHolder> fragmentsList;

    public SectionPagerAdapter(@NonNull FragmentManager fm, int behavior, List<FragmentHolder> fragmentsList) {
        super(fm, behavior);
        this.fragmentsList = fragmentsList;
    }

    @NonNull
    @Override
    public BaseFragment getItem(int position) {
        return fragmentsList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsList.get(position).getFragmentLabel();
    }

}
