package ru.mail.hometask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mail.hometask.Data.NumberModel;
import ru.mail.hometask.R;

public class SecondFragment extends Fragment {

    private NumberModel model;


    public SecondFragment(NumberModel model) {
        this.model = model;
    }

    public SecondFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("thisNumber", model.getmTitle());
        outState.putInt("thisColor", model.getmColor());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (model == null) {
            model = new NumberModel(savedInstanceState.getString("thisNumber"));
            model.setmColor(savedInstanceState.getInt("thisColor"));
        }

        View view = inflater.inflate(R.layout.second, container, false);
        TextView textView = view.findViewById(R.id.second);
        textView.setText(model.getmTitle());
        textView.setTextColor(model.getmColor());
        return view;
    }
}

