package com.example.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String info = extras.getString("info");
        String price = extras.getString("price");
        TextView tv1 = (TextView)findViewById(R.id.textView7);
        TextView tv2 = (TextView)findViewById(R.id.textView8);
        tv1.setText(info);
        tv2.setText(price);
    }
}
