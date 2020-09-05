package com.mascotassemanatres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyViewHolder> {
    String[] data;
    int[] ranking;
    int[] foto;
    Context context;

    public Adapter2(Context ct, String names[], int images[], int ranks[]) {
        context = ct;
        data = names;
        foto = images;
        ranking = ranks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Último
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.myText1.setText(data[position]);
        holder.myImg.setImageResource(foto[position]);
        holder.rankU.setText(String.valueOf(ranking[position]));
        holder.huesoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.rankU.setText(String.valueOf(ranking[position] + 1));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //
        TextView myText1;
        TextView rankU;
        ImageView myImg;
        ImageButton huesoBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //
            myText1 = itemView.findViewById(R.id.MyName);
            myImg = itemView.findViewById(R.id.ImageView);
            rankU = itemView.findViewById(R.id.rank);
            huesoBtn = itemView.findViewById(R.id.hueso);
        }
    }
}
