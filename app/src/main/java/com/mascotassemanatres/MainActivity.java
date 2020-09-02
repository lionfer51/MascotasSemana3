package com.mascotassemanatres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //3
    RecyclerView recyclerView;
    //1
    String names[];
    //2
    int images[]={R.drawable.raza1,R.drawable.raza2,R.drawable.raza3,R.drawable.raza4,R.drawable.raza5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //3
        recyclerView=findViewById(R.id.recyclerView);
        names=getResources().getStringArray(R.array.lista_mascotas);
        MyAdapter myAdapter=new MyAdapter(this,names,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}