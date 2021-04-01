package ua.com.foxminded.collectionsandmapsversion2.view;

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
import ua.com.foxminded.collectionsandmapsversion2.di.modules.PresenterFactory;

public abstract class BaseFragment<T> extends Fragment implements SizeProvider {

    @Inject
    PresenterFactory presenterFactory;

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

    public abstract void showInitiateCalculating();

    public abstract void publishOperationResult(Message message);

    public abstract Class<T> getPresenterClass();
}
