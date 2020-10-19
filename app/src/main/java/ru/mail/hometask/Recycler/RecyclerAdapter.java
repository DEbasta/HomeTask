package ru.mail.hometask.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mail.hometask.Model.NumberModel;
import ru.mail.hometask.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder>{

    private final List<NumberModel> mData;
    private final ActionListener clicked;

    public RecyclerAdapter(List<NumberModel> data,ActionListener clicked){
        this.mData=data;
        this.clicked=clicked;
    }


    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new RecyclerHolder(view,  clicked);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        NumberModel model =mData.get(position);
        holder.getView().setText(model.getmTitle());
        holder.getView().setTextColor(model.getmColor());
        holder.onBind(model);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    @Override
    public int getItemViewType(final int position) {
        return R.layout.number;
    }


    public interface ActionListener {
        void onItemClick(NumberModel model);
    }
}