package com.watermelon.citygame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.city_field_auto);
        textView.setText("Тюмень");
        bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) textView.getText();
                if(str.length() == 0)
                    Toast.makeText(MainActivity.this, "ты ничего не написал", Toast.LENGTH_SHORT).show();
            }
        });
    }
}