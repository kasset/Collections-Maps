package ua.com.foxminded.collectionsandmapsversion2;


import ua.com.foxminded.collectionsandmapsversion2.view.BaseFragment;

public class FragmentHolder {

    private BaseFragment fragment;
    private int fragmentKey;
    private String fragmentLabel;

    public FragmentHolder(BaseFragment fragment, int fragmentKey, String fragmentLabel) {
        this.fragment = fragment;
        this.fragmentLabel = fragmentLabel;
        this.fragmentKey = fragmentKey;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public String getFragmentLabel() {
        return fragmentLabel;
    }

    public int getFragmentKey() {
        return fragmentKey;
    }
}
