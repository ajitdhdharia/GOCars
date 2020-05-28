package com.example.gocars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MoveToView extends AppCompatActivity {
    public static FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_to_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        faltu_context.context=getApplicationContext();
        fm =  getSupportFragmentManager();
        if (findViewById(R.id.frag_cont_view)!=null)
        {
            if(savedInstanceState != null)
            { return;}

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            ListOfCar lg = new ListOfCar();
            fragmentTransaction.add(R.id.frag_cont_view, lg, null);
            fragmentTransaction.commit();
        }

    }
}
