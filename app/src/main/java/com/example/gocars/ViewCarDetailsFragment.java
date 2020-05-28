package com.example.gocars;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewCarDetailsFragment extends Fragment {
    Db_userRegd db;
    public TextView name,cost,description, seat ,ac ,door, type ;
  public ImageView img;
    public ViewCarDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.fragment_view_car_details, container, false);
          String value = getArguments().getString("YourKey");
       // Toast.makeText(faltu_context.context, "We get : "+ value, Toast.LENGTH_SHORT).show();
        name= view.findViewById(R.id.name);
        cost=view. findViewById(R.id.cost);
        img=view.findViewById(R.id.img);
        description= view.findViewById(R.id.description);
        seat= view.findViewById(R.id.seat);
        ac=view. findViewById(R.id.ac);
        door= view.findViewById(R.id.door);
        type= view.findViewById(R.id.type);
               db= new Db_userRegd(faltu_context.context);
        ArrayList<Model_Pojo> array_list = db.showImagesData(value);
        Model_Pojo objectModel =array_list.get(0);
       name.setText(objectModel.getImageName());
       cost.setText(objectModel.getExpectedcost());
       img.setImageBitmap(objectModel.getImage());
       description.setText(objectModel.getSpecification());
       seat.setText(objectModel.getNoOfseats());
       ac.setText(objectModel.getCoolingtype());
        door.setText(objectModel.getNoOfdoors());
        type.setText(objectModel.getDrivingmode());

        return view;
    }
}
