package ru.mail.hometask.Fragments;


import android.app.Activity;
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
import ru.mail.hometask.MainActivity;
import ru.mail.hometask.Model.NumberModel;
import ru.mail.hometask.R;
import ru.mail.hometask.Recycler.RecyclerAdapter;


public class FirstFragment extends Fragment {
    private List<NumberModel> number;

    private  RecyclerAdapter adapter;

    private int getColumnAmount() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return 3;
        return 4;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = DataSource.getInstance().getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.numbers_layout, group, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        setAdapter();

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), getColumnAmount(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.add);
        button.setOnClickListener(view1 -> {
            int nextNumber = number.size() + 1 ;
            number.add(number.size(),DataSource.createNumberElem(Integer.toString(nextNumber),nextNumber));
            adapter.notifyDataSetChanged();
        });
        return view;
    }

    void setAdapter(){
        adapter = new RecyclerAdapter(number, model -> {
            Activity activity = getActivity();
            ((MainActivity) activity).openFragment(model);
        });
    }
}
