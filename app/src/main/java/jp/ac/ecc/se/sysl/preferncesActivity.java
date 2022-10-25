package jp.ac.ecc.se.sysl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class preferncesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefernces);
        //このアプリの情報を保存するfile を設定
        SharedPreferences pref=getPreferences(Context.MODE_PRIVATE);
        EditText thoughtsText=findViewById(R.id.thoughtsText);
        Button saveBtn=findViewById(R.id.saveButton);
        Button resetBtn=findViewById(R.id.resetBttoun);
        Button cancelBtn=findViewById(R.id.cancel);
        String [] menu={"dry","cutlet","cheese","soup","memo"};
        //前画面からの情報を受け取る
        Intent intent=getIntent();
        int curry=intent.getIntExtra("curry",4);
        String thoughtsSt=pref.getString(menu[curry],"");
        thoughtsText.setText(thoughtsSt);
        SharedPreferences.Editor editor=pref.edit();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(menu[curry],thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"保存しました",Toast.LENGTH_SHORT).show();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(getApplicationContext(),"終了します",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("memo",null);
                editor.apply();
                Toast.makeText(getApplicationContext(),"リセットしました",Toast.LENGTH_SHORT).show();
                thoughtsText.setText(null);
            }
        });

    }
}