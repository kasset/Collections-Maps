package ua.com.foxminded.collectionsandmapsversion2.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import ua.com.foxminded.collectionsandmapsversion2.SizeProvider;
import ua.com.foxminded.collectionsandmapsversion2.di.modules.BasePresenterFactory;
import ua.com.foxminded.collectionsandmapsversion2.presenter.BasePresenter;

public abstract class BaseFragment extends Fragment implements SizeProvider {

    @Inject
    BasePresenterFactory presenterFactory;

    public BaseFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void sendSize(int size) {
    }

    public abstract void showInitiateCalculating();

    public abstract void publishOperationResult(Message message);

    protected abstract BasePresenter getPresenter(Class<?> presenterType);
}
