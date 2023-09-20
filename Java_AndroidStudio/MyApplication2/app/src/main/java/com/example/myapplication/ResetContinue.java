package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetContinue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_continue);

        //Daca se merge la urmatoarea pagina:
        configureBluetoothPage();
        configureFlickerPage();
    }
    private void configureBluetoothPage(){

            // Din butonul de next, mergi mai departe:
            Button nextButton = (Button) findViewById(R.id.buttonReset);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Din pagina curenta- MainActivity
                    // Se navigheaza catre clasa ResetContinue.java
                    startActivity(new Intent(ResetContinue.this, MainActivity.class ));
                }
            });


    }

    //buttonContinue
    private void configureFlickerPage(){

        // Din butonul de next, mergi mai departe:
        Button nextButton = (Button) findViewById(R.id.buttonContinue);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Din pagina curenta- MainActivity
                // Se navigheaza catre clasa ResetContinue.java
                startActivity(new Intent(ResetContinue.this, Flicker.class ));
            }
        });


    }

}