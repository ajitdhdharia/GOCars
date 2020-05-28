package com.example.gocars.ui.Change_City;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocars.City_pojo;
import com.example.gocars.Db_userRegd;
import com.example.gocars.Model;
import com.example.gocars.Model_Pojo;
import com.example.gocars.R;
import com.example.gocars.faltu_context;
import com.example.gocars.ui.gallery.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeCityFragment extends Fragment {
 Db_userRegd db;
 ListView listcity;
 TextView edit_city;
    private CityViewModel cityViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // cityViewModel =
               // ViewModelProviders.of(this).get(CityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_change_city, container, false);
        listcity=root.findViewById(R.id.listcity);
        edit_city=root.findViewById(R.id.edit_city);
       // final TextView textView = root.findViewById(R.id.text_city);
        db= new Db_userRegd(faltu_context.context);

        db.delcitydata();
        db.cityData();

        ArrayList<City_pojo> array_list = db.showcities();
       // City_pojo objectModel =array_list.get(0);
         List<String> fruits_list = new ArrayList<String>();
        for (int counter = 0; counter < array_list.size(); counter++) {
            City_pojo objectModel =array_list.get(counter);
            fruits_list.add(objectModel.getCityname());
        }
         final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1,android.R.id.text1, fruits_list);
        listcity.setAdapter(arrayAdapter);
        listcity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=arrayAdapter.getItem(position);
                edit_city.setText("");
                edit_city.setText(value);
              //  Toast.makeText(faltu_context.context,value,Toast.LENGTH_SHORT).show();

            }
        });
        //  holder.imageTV.setText(objectModel.getImageName());
        //ArrayList<String> array_list = db.showcities();
        //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
          //      (this, android.R.layout.simple_list_item_1, R.id.listcity,);
      //un  City_pojo city_pojo =array_list.get(0);
       // listcity.setText(city_pojo.getCityname());
       /* cityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
             //   textView.setText(s);
            }
        });*/
        return root;
    }
}
