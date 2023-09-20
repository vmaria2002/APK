package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Timer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        /**
         * Implementat navigare:
         * Timer -->Thank you.
         *
         * Obs: doar pentru testare pe moment...
         */

        pressStartButton();

        ImageView min = findViewById(R.id.setTime);

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
    }

    private void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(Timer.this, v);
        //preia meniul pop-up generat in: menu/popup_menu.xml
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //Selectare 10 min:
                if(item.getItemId() == R.id.TenMin){
                    Toast.makeText(Timer.this, "Tou select 10 min",Toast.LENGTH_SHORT);

                }

                if(item.getItemId() == R.id.TwentyMin){
                    Toast.makeText(Timer.this, "Tou select 20 min",Toast.LENGTH_SHORT);
                }

                if(item.getItemId() == R.id.ThirtiethMin){
                    Toast.makeText(Timer.this, "Tou select 30 min",Toast.LENGTH_SHORT);
                }


                return false;
            }
        });
        popupMenu.show();
    }
    private  void pressStartButton(){
        Button nextButton = (Button) findViewById(R.id.buttonStart);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Timer.this, ThankYouPage.class ));
            }
        });
    }
}