package jp.ac.ecc.se.sysl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_sub);
        setContentView(R.layout.activity_const);
      //  setContentView(R.layout.activity_const2);

        //setContentView(R.layout.activity_event);
        //setTitle("Empty Activity");


       //画面上のパーツ宣言部
        TextView nameLabel = findViewById(R.id.nameLabel);
        EditText nameText=findViewById(R.id.nameText2);
        Button clearButton=findViewById(R.id.ClearButton);
        Button comfirmButton= findViewById(R.id.button);
        Button sendButton=findViewById(R.id.sendButton);
        nameLabel.setText("Name");
        sendButton.setOnClickListener(this);
        comfirmButton.setOnClickListener(this);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });



    }

    @Override
    public void onClick(View view) {
        switch ((view.getId())){
            case R.id.sendButton:
                Toast.makeText(this,"送信Button clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(this,"確認Button clicked",Toast.LENGTH_SHORT).show();
                break;
        }
    }


}