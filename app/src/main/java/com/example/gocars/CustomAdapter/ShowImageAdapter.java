package com.example.gocars.CustomAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gocars.AdminLoginFragment;
import com.example.gocars.AdminTasks;
import com.example.gocars.Admin_car_Upload;
import com.example.gocars.Click_listner_fr_viewdetails;
import com.example.gocars.ListOfCar;
import com.example.gocars.Model;
import com.example.gocars.MoveToView;
import com.example.gocars.R;
import com.example.gocars.StartingActivity;
import com.example.gocars.ViewCarDetailsFragment;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.RVViewHolderClass> {
  private   ArrayList<Model> modelArrayList;
    private final Click_listner_fr_viewdetails listener;
    public ShowImageAdapter(ArrayList<Model> modelArrayList, Click_listner_fr_viewdetails listener) {
        this.modelArrayList = modelArrayList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public RVViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RVViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list,viewGroup,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolderClass holder, int position) {
        Model objectModel =modelArrayList.get(position);
        holder.imageTV.setText(objectModel.getImageName());
        holder.image.setImageBitmap(objectModel.getImage());
        holder.cost.setText(objectModel.getExpectedcost());
        holder.economy.setText(objectModel.getClasstype());
        holder.seats.setText(objectModel.getNoOfseats());
        holder.doors.setText(objectModel.getNoOfdoors());
        holder.air.setText(objectModel.getCoolingtype());
        holder.auto.setText(objectModel.getDrivingmode());
        holder.rating.setText(String.valueOf(objectModel.getId()));

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class RVViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView imageTV,cost,economy,seats,doors,air,auto, rating;
        Button button;
        ImageView image ;
        private WeakReference<Click_listner_fr_viewdetails> listenerRef;
        public RVViewHolderClass(@NonNull View itemView, Click_listner_fr_viewdetails listener) {
            super(itemView);
            listenerRef = new WeakReference<>(listener);
            imageTV=itemView.findViewById(R.id.image_name);
            image=itemView.findViewById(R.id.img);
            cost=itemView.findViewById(R.id.cost);
            economy=itemView.findViewById(R.id.economy);
            seats=itemView.findViewById(R.id.seats);
            doors=itemView.findViewById(R.id.doors);
            air=itemView.findViewById(R.id.air);
            auto=itemView.findViewById(R.id.auto);
            rating=itemView.findViewById(R.id.rating);
            button=itemView.findViewById(R.id.button);
            itemView.setOnClickListener(this);

            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == button.getId()) {
                //=rating.getText().toString();
                Toast.makeText(v.getContext(), "ITEM PRESSED = " + rating.getText().toString()+String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                ViewCarDetailsFragment ldf = new ViewCarDetailsFragment ();
                Bundle args = new Bundle();
                args.putString("YourKey", rating.getText().toString());
                ldf.setArguments(args);
                MoveToView. fm.beginTransaction().replace(R.id.frag_cont_view, ldf).commit();
              //  AdminTasks.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new ViewCarDetailsFragment(), ldf).commit();

               // Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            } else {
               // Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }

            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }


}
