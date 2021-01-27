package edu.sjsu.android.activityloaderactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Uri webpage = Uri.parse("https://www.amazon.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                String title = getResources().getString(R.string.chooser_title);
                Intent chooser = Intent.createChooser(webIntent, title);

                startActivity(chooser);
                break;

            case R.id.button2:
                String myDial = "tel:+194912344444";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(myDial));
                startActivity(intent);
                break;
        }
    }
}