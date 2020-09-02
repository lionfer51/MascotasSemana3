package com.mascotassemanatres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    String[] data;
    int[] foto;
    Context context;
    public MyAdapter(Context ct, String names[], int images[]){
        context=ct;
        data=names;
        foto=images;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Último
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data[position]);
        holder.myImg.setImageResource(foto[position]);
    }
    @Override
    public int getItemCount() {
        return data.length;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //
        TextView myText1;
        ImageView myImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //
            myText1=itemView.findViewById(R.id.MyName);
            myImg=itemView.findViewById(R.id.ImageView);
        }
    }

}
