package com.example.signuplogin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //Declare Variable
    private List<HashMap<String,String>> data;
    private Context context;

    //Cnstructor
    public Adapter(Context context, List<HashMap<String,String>> data){
        //parameter assign to class variable
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    //Initialize recycleview item Layout here
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize item Layout
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyViewHolder vh=new MyViewHolder(view);//call view holder
        return vh;
    }

    @Override
    //Bind data or add data item here
    public void onBindViewHolder(@NonNull final Adapter.MyViewHolder holder, final int position) {


        String id=data.get(position).get("id");
        String name=data.get(position).get("name");
        String email=data.get(position).get("email");

        holder.txtId.setText("ID: "+id);
        holder.txtName.setText("Name: "+name);
        holder.txtEmail.setText("Email: "+email);

    }

    @Override
    public int getItemCount() {
        return data.size();
    } //for item count

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Declare view item component
        TextView txtId,txtName,txtEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId=itemView.findViewById(R.id.txt_id);
            txtName=itemView.findViewById(R.id.txt_name);
            txtEmail=itemView.findViewById(R.id.txt_email);
        }
    }
}
