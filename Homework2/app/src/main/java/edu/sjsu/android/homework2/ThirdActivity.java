package edu.sjsu.android.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

         button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:88888888"));
                startActivity(intent);*/

                String myDial = "tel:888-8888";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(myDial));
                startActivity(intent);
            }
        });
    }

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
            Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
            startActivity(intent);
        }

        if (id == R.id.item3) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:com.edu.sjsu.android.homework2"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

   /* public void onDialButton(View v){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:88888888"));
        startActivity(intent);
    }*/
}