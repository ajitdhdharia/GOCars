package com.example.gocars.ui.ChangePassword;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocars.Db_userRegd;
import com.example.gocars.R;
import com.example.gocars.faltu_context;
import com.example.gocars.global_vars;
import com.example.gocars.ui.Change_City.CityViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePasswordFragment extends Fragment {
    EditText edit_email,edit_pass,edit_newpass,edit_confirm;
    Button recoverybtn;
    Db_userRegd db;
    private ChangePasswordViewModel changePasswordViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_change_password, container, false);
        edit_email=(EditText)root.findViewById(R.id.edit_email);
        recoverybtn=(Button)root.findViewById(R.id.recoverybtn);
        edit_pass=(EditText)root.findViewById(R.id.edit_pass);
        edit_newpass=(EditText)root.findViewById(R.id.edit_newpass);
        edit_confirm=(EditText)root.findViewById(R.id.edit_confirm);

        db= new Db_userRegd(faltu_context.context);
        changePasswordViewModel =
                ViewModelProviders.of(this).get(ChangePasswordViewModel.class);

     //   final TextView textView = root.findViewById(R.id.text_cpass);
        changePasswordViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        Cursor res =  db.changePass(((global_vars) getActivity().getApplication()).getLoginUserID());


        if(res.moveToFirst())
        {

            edit_email.setText(res.getString(3).toString());


        }
        recoverybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword(v);
            }
        });
        return root;
    }
    public void changePassword(View view) {
        Cursor res1 =  db.changePass(((global_vars) getActivity().getApplication()).getLoginUserID());
      res1.moveToFirst();
        if((edit_pass.getText().toString().equals(res1.getString(5).toString()))){

        }
        else{
            Toast.makeText(getActivity(),"Please enter your current Password ",Toast.LENGTH_LONG).show();
            return;}
        if ((edit_email.getText().toString()).equals("")||(edit_pass.getText().toString()).equals("")||(edit_newpass.getText().toString()).equals("")||(edit_confirm.getText().toString()).equals("")) {

            Toast.makeText(getActivity(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if ((edit_confirm.getText().toString().equals(edit_newpass.getText().toString().trim()))) {}
else{
            Toast.makeText(getActivity(), "New Password didn't match with confirm password", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isUpdate = db.updatePassword(String.valueOf(((global_vars) getActivity().getApplication()).getLoginUserID()),edit_newpass.getText().toString().trim());
        if(isUpdate == true)
            Toast.makeText(getActivity(),"Password Updated Successfully",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getActivity(),"Error while updating Password",Toast.LENGTH_SHORT).show();

        // Toast.makeText(getApplicationContext(),"login called",Toast.LENGTH_SHORT).show();





    }

}
