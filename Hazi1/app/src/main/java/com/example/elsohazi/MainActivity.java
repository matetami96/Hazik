package com.example.elsohazi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText szam1 = (EditText)findViewById(R.id.editText);
        final EditText szam2 = (EditText)findViewById(R.id.editText2);
        Button osszeadas = (Button)findViewById(R.id.button);
        Button kivonas = (Button)findViewById(R.id.button2);
        Button szorzas = (Button)findViewById(R.id.button3);
        Button osztas = (Button)findViewById(R.id.button4);
        final TextView tv = (TextView)findViewById(R.id.textView);

        osszeadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eredmeny = Double.parseDouble(szam1.getText().toString()) + Double.parseDouble(szam2.getText().toString());
                tv.setText(Double.toString(eredmeny));
            }
        });

        kivonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eredmeny = Double.parseDouble(szam1.getText().toString()) - Double.parseDouble(szam2.getText().toString());
                tv.setText(Double.toString(eredmeny));
            }
        });

        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eredmeny = Double.parseDouble(szam1.getText().toString()) * Double.parseDouble(szam2.getText().toString());
                tv.setText(Double.toString(eredmeny));
            }
        });

        osztas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eredmeny = Double.parseDouble(szam1.getText().toString()) / Double.parseDouble(szam2.getText().toString());
                tv.setText(Double.toString(eredmeny));
            }
        });
    }
}
