package com.watermelon.citygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView cityFieldAuto;
    EditText cityField;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.button);
        cityFieldAuto = findViewById(R.id.city_field_auto);
        cityField = findViewById(R.id.city_field);
        ArrayList<String> cities = new ArrayList<>();
        String fileStr = "";
        try {
            Resources res = getResources();
            InputStream inputStream = res.openRawResource(R.raw.city);
            Scanner s = new Scanner(inputStream);
            while (s.hasNext())
                cities.add(s.next());
            System.out.println(fileStr);
        } catch (Exception e) {
            e.printStackTrace();
        }


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = cityField.getText().toString();
                if(str.length() == 0)
                    Toast.makeText(MainActivity.this, "ты ничего не написал", Toast.LENGTH_SHORT).show();
            }
        });
    }
}