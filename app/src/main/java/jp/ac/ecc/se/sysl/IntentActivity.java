package jp.ac.ecc.se.sysl;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentActivity extends AppCompatActivity {
    final int CAMERA_RESULT = 100;
    Uri imageUri;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== CAMERA_RESULT && resultCode == RESULT_OK){
           // Bitmap bitmap = data.getParcelableExtra("data");
            ImageView cameraImage=findViewById(R.id.cameraImage);
            //cameraImage.setImageBitmap(bitmap);
            cameraImage.setImageURI(imageUri);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        Intent intImage= new Intent(this,ImageActivity.class);
        EditText serchText=findViewById(R.id.serchText);
        Button serchButton=findViewById(R.id.serchButton);
        Button cameraButton = findViewById(R.id.cameraButton);
        Button confirmfab=findViewById(R.id.confirmFab);
        confirmfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageUri!=null){
                  intImage.putExtra("uri",imageUri);
                   startActivity(intImage);
                }
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName= "Traning_"+ timestamp + "_.jpg";
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE,fileName);
                values.put(MediaStore.Images.Media.MIME_TYPE,"image/jpeg");
                imageUri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,CAMERA_RESULT);

            }
        });
        serchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query=serchText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,query);
                startActivity(intent);
            }
        });
    }
}