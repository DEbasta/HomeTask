package ru.mail.hometask.Recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hometask.Recycler.RecyclerAdapter.ActionListener;
import ru.mail.hometask.Data.NumberModel;
import ru.mail.hometask.R;

public class RecyclerHolder extends RecyclerView.ViewHolder {

    private final TextView view;
    private final ActionListener actionListener;


    public RecyclerHolder(@NonNull View itemView, ActionListener clickAction) {
        super(itemView);
        view = itemView.findViewById(R.id.number);
        actionListener = clickAction;
    }


    public TextView getView() {
        return view;
    }


    public void onBind(final NumberModel id) {
        view.setOnClickListener(view1 -> actionListener.onItemClick(id));
    }
}
