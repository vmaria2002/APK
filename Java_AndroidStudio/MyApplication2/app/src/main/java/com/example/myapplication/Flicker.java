package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicker);

        pressButtonYellow();
        pressButtonBlue();
        pressButtonWithoutFlicler();

    }
    private void pressButtonYellow(){
        Button nextButton = (Button) findViewById(R.id.buttonYellow);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Flicker.this, Buzzer.class ));
            }
        });
    }
    private void pressButtonBlue(){
        Button nextButton = (Button) findViewById(R.id.buttonBlue);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Flicker.this, Buzzer.class ));
            }
        });
    }
    private void pressButtonWithoutFlicler(){
        Button nextButton = (Button) findViewById(R.id.buttonWithoutFlicker);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Flicker.this, Buzzer.class ));
            }
        });
    }
}