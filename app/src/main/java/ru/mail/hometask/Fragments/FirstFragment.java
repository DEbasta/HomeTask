package ru.mail.hometask.Fragments;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mail.hometask.Data.DataSource;
import ru.mail.hometask.Data.NumberModel;
import ru.mail.hometask.R;
import ru.mail.hometask.Recycler.RecyclerAdapter;
import ru.mail.hometask.Recycler.RecyclerAdapter.ActionListener;


public class FirstFragment extends Fragment {

    private List<NumberModel> number;
    private RecyclerAdapter adapter;
    private ActionListener listener;


    private int getColumnAmount() {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return getResources().getInteger(R.integer.straight);
        return getResources().getInteger(R.integer.akhtung);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionListener) context;
        number = DataSource.getInstance().getData();
        adapter = new RecyclerAdapter(number, model -> listener.onItemClick(model));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numbers_layout, group, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), getColumnAmount(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.add);
        button.setOnClickListener(view1 -> {
            int next = number.size() + 1;
            number.add(number.size(), DataSource.createNumberElem(Integer.toString(next), next));
            adapter.notifyDataSetChanged();
        });
        return view;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
