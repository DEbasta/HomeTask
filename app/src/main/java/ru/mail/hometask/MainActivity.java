package ru.mail.hometask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.mail.hometask.Fragments.FirstFragment;
import ru.mail.hometask.Fragments.SecondFragment;
import ru.mail.hometask.Data.NumberModel;
import ru.mail.hometask.Recycler.RecyclerAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ActionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentByTag("tag") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments, new FirstFragment())
                    .commit();
    }


    @Override
    public void onItemClick(NumberModel model) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments, new SecondFragment(model), "tag")
                .addToBackStack(null)
                .commit();
    }
}
