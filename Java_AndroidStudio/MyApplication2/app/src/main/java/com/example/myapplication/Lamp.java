package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lamp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp);

        pressLeftButton();
        pressRightButton();
        pressBothLampsButton();

    }

    private void pressLeftButton(){
        Button nextButton = (Button) findViewById(R.id.buttonLeft);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lamp.this, Timer.class ));
            }
        });
    }
    private void pressRightButton(){
        Button nextButton = (Button) findViewById(R.id.buttonRight);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lamp.this, Timer.class ));
            }
        });
    }

    private void pressBothLampsButton(){
        Button nextButton = (Button) findViewById(R.id.buttonBoth);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lamp.this, Timer.class ));
            }
        });
    }
}