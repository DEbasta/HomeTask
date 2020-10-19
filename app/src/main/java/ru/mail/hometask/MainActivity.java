package ru.mail.hometask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.mail.hometask.Fragments.FirstFragment;
import ru.mail.hometask.Fragments.SecondFragment;
import ru.mail.hometask.Model.NumberModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments, new FirstFragment())
                .commit();
    }

    public void openFragment(NumberModel model) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments, new SecondFragment(model))
                .addToBackStack(null)
                .commit();
    }

}
