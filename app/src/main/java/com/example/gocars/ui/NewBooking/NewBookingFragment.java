package com.example.gocars.ui.NewBooking;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.gocars.City_pojo;
import com.example.gocars.Db_userRegd;
import com.example.gocars.MoveToView;
import com.example.gocars.NavigationActivity;
import com.example.gocars.R;
import com.example.gocars.StartingActivity;
import com.example.gocars.UserRegFragment;
import com.example.gocars.ViewCarDetailsFragment;
import com.example.gocars.faltu_context;
import com.example.gocars.ui.Change_City.CityViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewBookingFragment extends Fragment {
   private Button searchbtn;
    Button btnDatePicker, btnTimePicker,btn_dropdate,btn_droptime;
    EditText txtDate, txtTime;
    Spinner pickup,dropup;
    Db_userRegd db;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private NewBookingViewModel newBookingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newBookingViewModel =
                ViewModelProviders.of(this).get(NewBookingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_booking, container, false);
        searchbtn=root.findViewById(R.id.searchbtn);
        btnDatePicker=(Button)root.findViewById(R.id.btn_date);
        btnTimePicker=(Button)root.findViewById(R.id.btn_time);
        btn_dropdate=(Button)root.findViewById(R.id.btn_dropdate);
        btn_droptime=(Button)root.findViewById(R.id.btn_droptime);
        pickup=(Spinner)root.findViewById(R.id.et_pickup) ;
        dropup=(Spinner)root.findViewById(R.id.et_dropoff) ;
        db= new Db_userRegd(faltu_context.context);

        db.delcitydata();
        db.cityData();
        ArrayList<City_pojo> array_list = db.showcities();
        // City_pojo objectModel =array_list.get(0);
        List<String> fruits_list = new ArrayList<String>();
        for (int counter = 0; counter < array_list.size(); counter++) {
            City_pojo objectModel =array_list.get(counter);
            fruits_list.add(objectModel.getLocation());
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1,android.R.id.text1, fruits_list);
        pickup.setAdapter(arrayAdapter);
        dropup.setAdapter(arrayAdapter);





        //searchlist
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(), MoveToView.class);
               startActivity(i);
            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnDatePicker) {

                    // Get Current Date
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);


                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    btnDatePicker.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            }
        });

    btnTimePicker.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btnTimePicker) {

                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                btnTimePicker.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        }
    });
    btn_dropdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_dropdate) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                btn_dropdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        }
    });
    btn_droptime.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btn_droptime) {

                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                btn_droptime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        }
    });
      //  final TextView textView = root.findViewById(R.id.text_newBooking);
        newBookingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        return root;



}
}
