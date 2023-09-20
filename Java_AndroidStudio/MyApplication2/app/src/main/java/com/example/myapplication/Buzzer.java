package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buzzer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer);
        pressYesButton();
        pressNoButton();
    }
   private void pressYesButton(){
       Button nextButton = (Button) findViewById(R.id.buttonYes);
       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Buzzer.this, Lamp.class ));
           }
       });
   }

   private void pressNoButton(){
       Button nextButton = (Button) findViewById(R.id.buttonNo);
       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Buzzer.this, Lamp.class ));
           }
       });
   }

}
