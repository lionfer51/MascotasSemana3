package com.mascotassemanatres;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListadoMascotasLike extends AppCompatActivity {
    RecyclerView recyclerView;
    String names[];
    int ranks[] = {30, 39, 34, 25, 26, 18, 32, 25};
    //2
    int images[] = {R.drawable.raza1, R.drawable.raza2, R.drawable.raza3, R.drawable.raza4, R.drawable.raza5, R.drawable.raza6, R.drawable.raza7, R.drawable.raza8};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mascotas_like);
        /*Toolbar toolbar;
        toolbar=findViewById(R.id.MyToolbar);*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //
        recyclerView = findViewById(R.id.recyclerView2);
        names = getResources().getStringArray(R.array.lista_mascotas);
        Adapter2 Adapter2 = new Adapter2(this, names, images, ranks);
        recyclerView.setAdapter(Adapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}