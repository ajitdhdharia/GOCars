package com.example.gocars;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocars.CustomAdapter.ShowImageAdapter;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListOfCar extends Fragment {
    private Db_userRegd databaseHandler;
    private RecyclerView recyclerView;
    private ShowImageAdapter rvAdapter;
//TextView rating;
    public ListOfCar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.fragment_list_of_car, container, false);
        recyclerView= view.findViewById(R.id.carrecycle);
        databaseHandler=new Db_userRegd(faltu_context.context);
      //  rating=view.findViewById(R.id.rating);
        rvAdapter =new ShowImageAdapter(databaseHandler.getAllImagesData(), new Click_listner_fr_viewdetails() {
            @Override
            public void onPositionClicked(int position) {
               // Toast.makeText(getContext(), "ITEM PRESSED = " + String.valueOf(position), Toast.LENGTH_SHORT).show();
                //   Toast.makeText(getContext(), "ITEM PRESSED = Lidt of car"+rating.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });
            recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
        recyclerView.setAdapter(rvAdapter);



        return view;
    }

////////

}