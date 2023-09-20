package com.example.myapplication;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.util.Set;


//ListActivity: elemeente si gestioneaza interactiunea cu acestea
// selectarea elemente, click pe ele
public class ListOfDevices extends ListActivity {
    private BluetoothAdapter myBluetoothAdapter = null;
    static String MAC_Address = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> ArrayBluetooth = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Set<BluetoothDevice> devicesFounded = myBluetoothAdapter.getBondedDevices();
        if(devicesFounded.size()>0){
            for (BluetoothDevice device:devicesFounded){
                 String name = device.getName();
                 String MAC = device.getAddress();
                 ArrayBluetooth.add(name+"\n"+MAC);

            }
        }
      setListAdapter(ArrayBluetooth);
    }

    AdapterView.OnItemClickListener mMessageClickedHandler=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String infoMAC = ((TextView)view).getText().toString();

        String info = infoMAC.substring(infoMAC.length()-17);
        Toast.makeText(getApplicationContext(), "Inforamation: "+info, Toast.LENGTH_LONG).show();

        Intent MAC = new Intent();
        MAC.putExtra(MAC_Address, info);
        setResult(RESULT_OK, MAC);

        finish();
        }
    };
}
