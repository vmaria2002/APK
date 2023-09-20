package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThankYouPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_page);

        pressHomeButton();
        pressExitButton();

    }

    private void pressHomeButton(){

            Button nextButton = (Button) findViewById(R.id.buttonHome);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(ThankYouPage.this, MainActivity.class ));
                }
            });
        }
    private void pressExitButton(){

        Button nextButton = (Button) findViewById(R.id.buttonExit);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

}