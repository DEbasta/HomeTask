package ru.mail.hometask.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hometask.Adapter.RecyclerAdapter;
import ru.mail.hometask.Model.NumberModel;
import ru.mail.hometask.R;

public class RecyclerHolder extends RecyclerView.ViewHolder {
    private TextView view;
    private final RecyclerAdapter.ActionListener actionListener;

    public RecyclerHolder(@NonNull View itemView, RecyclerAdapter.ActionListener clickAction) {
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
