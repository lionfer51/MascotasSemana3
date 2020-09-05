package com.mascotassemanatres;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_REQUEST = 9999;
    //3
    RecyclerView recyclerView;
    //
    String names[];
    int ranks[] = {29, 38, 33, 24, 25, 17, 31, 24};
    //2
    int images[] = {R.drawable.raza1, R.drawable.raza2, R.drawable.raza3, R.drawable.raza4, R.drawable.raza5, R.drawable.raza6, R.drawable.raza7, R.drawable.raza8};
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        ActionMenuView starBtn = findViewById(R.id.btnStar);
        //3
        recyclerView = findViewById(R.id.recyclerView1);
        names = getResources().getStringArray(R.array.lista_mascotas);
        MyAdapter myAdapter = new MyAdapter(this, names, images, ranks);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton camara = findViewById(R.id.floatingActionButton);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.btnStar:
                cambioSegunda();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cambioSegunda() {
        Intent i = new Intent(MainActivity.this, ListadoMascotasLike.class);
        startActivity(i);
    }
}