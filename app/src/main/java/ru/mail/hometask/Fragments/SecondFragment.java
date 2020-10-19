package ru.mail.hometask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mail.hometask.Model.NumberModel;
import ru.mail.hometask.R;

public class SecondFragment extends Fragment {
    private final NumberModel model;

    public SecondFragment(NumberModel model) {
        this.model = model;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second, container, false);
        TextView textView = view.findViewById(R.id.second);
        textView.setText(model.getmTitle());
        textView.setTextColor(model.getmColor());
        return view;
    }
}

