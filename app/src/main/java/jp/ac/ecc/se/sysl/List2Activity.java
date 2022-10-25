package jp.ac.ecc.se.sysl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        setTitle("練習アプリ");
        Intent intsub=new Intent(this,SubActivity.class);
        Intent intevent=new Intent(this,EventActivity.class);
        ListView viewlist=findViewById(R.id.showdata);
        EditText input=findViewById(R.id.input);
        Button addBtn=findViewById(R.id.addBtn);
        ArrayList<String> datalist = new ArrayList<>();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datalist);
        viewlist.setAdapter(adapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tt=input.getText().toString();
                if(!tt.equals("")) {
                    datalist.add(tt);
                    viewlist.setAdapter(adapter);
                    input.setText("");
                }

            }
        });

        viewlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i%2){
                    case 0:
                        startActivity(intevent);
                        break;
                    case 1:
                        startActivity(intsub);
                        break;
                }
            }
        });
    }
}