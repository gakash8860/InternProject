package com.example.internproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Spinner spinner;
        Button calculate;
        final int petrol=80;
        EditText pickup,drop;
        ImageView imageView;
        TextView textView,result;
        int numberbar[]={0,7,8,4,15,5,5,7,8,6,6};
        float firstbar[]={0,1.1f,1.1f,1.2f,1.0f,1.1f,1.1f,1.9f,2.0f,2.6f,2.6f};
        float result2;
        int index;
        int dropnum;
         int pickupnum;
        String ar[]={"Select Bike/Scooter","Activa 125cc","Activa","Aviator","Jupiter","Maestro","Access 125cc","HF delux ","CT 100","FZS","Avenger street 220"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);
        pickup=findViewById(R.id.pickup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        calculate=findViewById(R.id.button);
        drop=findViewById(R.id.drop);
        result=findViewById(R.id.result);
        imageView.setImageResource(R.drawable.aaaa);
        textView.setPaintFlags(textView.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter ard=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ar);
        ard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ard);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropnum = Integer.parseInt(drop.getText().toString());
                pickupnum = Integer.parseInt(pickup.getText().toString());

                if (pickupnum <= numberbar[index]) {
                    if (pickupnum == numberbar[index]) {

                        if ((pickupnum - dropnum) == 1) {
                            result2 = (pickupnum - dropnum) * firstbar[index] * petrol;
                        }

                        if ((pickupnum - dropnum) > 1) {
                            result2 = firstbar[index] * petrol + (pickupnum - dropnum - 1) * firstbar[index] * petrol;
                        }

                    }

                    if (pickupnum != numberbar[index]) {
                        result2 = (pickupnum - dropnum) * firstbar[index] * petrol;
                    }
                    if (dropnum < pickupnum) {
                        result.setTextColor(getResources().getColor(R.color.Green));
                        result.setText("" + result2);
                    }
                    if (dropnum > pickupnum) {
                        result.setTextColor(getResources().getColor(R.color.Red));
                        result.setText("" + result2);
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Wrong Input According to Vehicle", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}