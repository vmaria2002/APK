package com.example.myapplication;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MainActivity extends Activity {
    public static final int MESSAGE_READ = 0;
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView out = (TextView) findViewById(R.id.out);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            out.append("device not supported");
        }
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // Verificați dacă aveți permisiunea BLUETOOTH_CONNECT

                        // Dacă permisiunea nu este acordată, trebuie să o solicitați
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 22);
                        return;
                    }
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                    // Verificați dacă aveți permisiunea BLUETOOTH_SCAN

                    // Dacă permisiunea nu este acordată, trebuie să o solicitați
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_SCAN}, 22);
                    return;
                }

                if (!mBluetoothAdapter.isDiscovering()) {
                    //out.append("MAKING YOUR DEVICE DISCOVERABLE");
                    Toast.makeText(getApplicationContext(), "MAKING YOUR DEVICE DISCOVERABLE", Toast.LENGTH_LONG).show(); // Adăugați show() pentru a afișa mesajul Toast
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

                    startActivityForResult(enableBtIntent, REQUEST_DISCOVERABLE_BT);
                    Toast.makeText(getApplicationContext(), enableBtIntent.toString(), Toast.LENGTH_LONG).show(); // Trebuie să apelați show() pentru a afișa mesajul Toast


                }else {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

                    startActivityForResult(enableBtIntent, REQUEST_DISCOVERABLE_BT);
                    Toast.makeText(getApplicationContext(), enableBtIntent.toString(), Toast.LENGTH_LONG).show(); // Trebuie să apelați show() pentru a afișa mesajul Toast

                }

            }

        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
                    // Verifică permisiunea BLUETOOTH_ADMIN în loc de BLUETOOTH_CONNECT

                    // Dacă permisiunea nu este acordată, trebuie să o solicitați
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_ADMIN}, 22);

                    // Nu dezactivați aici Bluetooth, deoarece nu aveți permisiune
                } else {
                    // Aveți permisiunea, puteți dezactiva Bluetooth
                    mBluetoothAdapter.getAddress();
                    //out.append("TURN_OFF BLUETOOTH");
                    Toast.makeText(getApplicationContext(), mBluetoothAdapter.getAddress(), Toast.LENGTH_LONG).show(); // Trebuie să apelați show() pentru a afișa mesajul Toast
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Toast.makeText(getApplicationContext(), menu.toString(), Toast.LENGTH_LONG).show(); // Trebuie să apelați show() pentru a afișa mesajul Toast

        return true;
    }

}