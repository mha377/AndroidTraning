package jp.ac.ecc.se.sysl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView image1=findViewById(R.id.image1);
        Intent intent=getIntent();
        Uri imageuri2=intent.getParcelableExtra("uri");
        image1.setImageURI(imageuri2);
    }
}