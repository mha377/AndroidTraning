package jp.ac.ecc.se.sysl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("練習アプリ");
        Intent intpref=new Intent(this,preferncesActivity.class);
        String[] curryList={"ドライカレー","カツカレー","チーズカレー","スープカレー"};
        //画面上のパーツ登録
        ListView listview= findViewById(R.id.curryList);
        //配列セット用のアダプター宣言
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,curryList);
        //画面上のListviewにアダプターのはいれつだデータ表示
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv=(TextView) view;String st=(String) adapterView.getItemAtPosition(i);
              // Integer it=(Integer) adapterView.getItemAtPosition(i);

               // Toast.makeText(getApplicationContext(),tv.getText(),Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_SHORT).show();
                //iが何番目を選んだか
               // Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();
                //何番目を選んだかを送る
                intpref.putExtra("curry",i);
               //画面の移動
                startActivity(intpref);


            }
        });

    }
}