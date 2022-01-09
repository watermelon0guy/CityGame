package com.watermelon.citygame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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