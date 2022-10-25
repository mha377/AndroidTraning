package jp.ac.ecc.se.sysl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setTitle("練習アプリ");
        Intent intsub=new Intent(this,SubActivity.class);
        Intent intent=getIntent();
        int age=intent.getIntExtra("age",25);
        TextView profile=findViewById(R.id.profile);
        Button clear1=findViewById(R.id.clear1);
        Button clear2=findViewById(R.id.clear2);
        EditText name=findViewById(R.id.name３);
        CheckBox age1=findViewById(R.id.age1);
        CheckBox age2=findViewById(R.id.age2);
        CheckBox age3=findViewById(R.id.age3);
        RadioButton man=findViewById(R.id.man);
        RadioButton women=findViewById(R.id.women);
        EditText password=findViewById(R.id.password);
        Button comfirm2=findViewById(R.id.button2);
        clear1.setOnClickListener(this);
        clear2.setOnClickListener(this);
        comfirm2.setOnClickListener(this);
        comfirm2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
               if(man.isChecked()==true){
                   Toast.makeText(getApplicationContext(),"男",Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getApplicationContext(),"女",Toast.LENGTH_SHORT).show();
               }
               finish();
               return false;
            }
        });

       clear2.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               setTitle(password.getText());
               return false;
           }
       });
    }

    @Override
    public void onClick(View view) {
        EditText name=findViewById(R.id.name３);
        EditText password=findViewById(R.id.password);
        switch (view.getId()){
            case R.id.clear1:
                name.setText("");
                break;
            case R.id.clear2:
                password.setText("");
                break;
            case R.id.button2:
                Toast.makeText(this,name.getText(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}