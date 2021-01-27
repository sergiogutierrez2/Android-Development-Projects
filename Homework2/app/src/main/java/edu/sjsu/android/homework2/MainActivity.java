package edu.sjsu.android.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // private Button button1;
    private Button button2;
    private Button button3;
    Button dial;

    RecyclerView recyclerView;

    String animalst[], descriptionst[];
    int images [] = {R.drawable.crocodile, R.drawable.leopard,
            R.drawable.lion, R.drawable.tiger, R.drawable.wolf};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   button1 = (Button) findViewById(R.id.button1); // dial button

        recyclerView  = findViewById(R.id.recyclerView);

        animalst = getResources().getStringArray(R.array.animals);
        descriptionst = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, animalst, descriptionst, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();

            }
        });*/

      /*  button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:88888888"));
                startActivity(intent);
            }
        });*/

    }
/*
    public void openActivity2(){
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Fetching the ids of the menu items from the action bar
        if (id == R.id.item2) {

            //Building an Intent object to start another activity
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        }

        if (id == R.id.item3) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:com.edu.sjsu.android.homework2"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
     }
/*
     public void onDialButton(View v){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:88888888"));
        startActivity(intent);
     }*/
}