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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        ArrayList<String> cities_original = fileToArray(R.raw.city);
        ArrayList<String> cities_current = (ArrayList<String>)cities_original.clone();

        int index = Math.abs((int)(Math.random() * cities_original.size() - 1));

        cityFieldAuto.setText(cities_original.get(index));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String autoCityStr = cityFieldAuto.getText().toString();
                String cityStr = cityField.getText().toString();
                boolean flag = true;
                if(cityStr.length() == 0)
                    Toast.makeText(MainActivity.this, "Ты ничего не написал", Toast.LENGTH_SHORT).show();
                else if (cityStr.toLowerCase().charAt(0) != autoCityStr.charAt(autoCityStr.length() - 1))
                {
                    Toast.makeText(MainActivity.this, "Слово не подходит", Toast.LENGTH_SHORT).show();
                }
                else if(!contain(cityStr,cities_current))
                {
                    Toast.makeText(MainActivity.this, "Такого слова нет или оно уже было :D", Toast.LENGTH_SHORT).show();
                }
                else {
                    Collections.shuffle(cities_current);
                    for (int i = 0; i < cities_current.size(); i++) {
                        String city = cities_current.get(i);
                        if (city.toLowerCase().charAt(0) == cityStr.toLowerCase().charAt(cityStr.length()-1))
                        {
                            if (cityStr.toLowerCase().charAt(cityStr.length()-1)=='ь' || cityStr.toLowerCase().charAt(cityStr.length()-1)=='ы' || cityStr.toLowerCase().charAt(cityStr.length()-1)=='й')
                                continue;
                            cityFieldAuto.setText(city);
                            cityField.setText("");
                            cities_current.remove(i);
                            Toast.makeText(MainActivity.this, "Слово нашлось!", Toast.LENGTH_SHORT).show();
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        cityFieldAuto.setText("Слова на такую букву нет. Вы победили!");
                        bt.setClickable(false);
                    }
                }
            }
        });
    }

    ArrayList<String> fileToArray(int file)
    {
        ArrayList<String> cities = new ArrayList<>();
        try {
            Resources res = getResources();
            InputStream inputStream = res.openRawResource(file);
            Scanner s = new Scanner(inputStream);
            while (s.hasNext())
                cities.add(s.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    Boolean contain(String string, ArrayList<String> list)
    {
        for (String str :
                list) {
            if(str.equals(string)) {
                list.remove(str);
                return true;
            }
        }
        return false;
    }
}