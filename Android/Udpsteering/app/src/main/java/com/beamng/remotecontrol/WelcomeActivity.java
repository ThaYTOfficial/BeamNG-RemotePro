package com.beamng.remotecontrol;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    public static final int CAM_PERMISSION_REQUEST = 100;
    public static final String PREFS_NAME = "UserSettings";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        android.widget.RadioGroup steeringGroup = (android.widget.RadioGroup) findViewById(R.id.steeringModeGroup);
        android.widget.RadioButton mode90 = (android.widget.RadioButton) findViewById(R.id.mode90);
        android.widget.RadioButton mode360 = (android.widget.RadioButton) findViewById(R.id.mode360);

        // Load saved preference
        android.content.SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        int use360 = settings.getInt("steering360", 0);

        if (use360 == 1) {
            mode360.setChecked(true);
        } else {
            mode90.setChecked(true);
        }

        steeringGroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {
                android.content.SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                android.content.SharedPreferences.Editor editor = settings.edit();
                
                if (checkedId == R.id.mode360) {
                    editor.putInt("steering360", 1);
                } else {
                    editor.putInt("steering360", 0);
                }
                editor.commit();
            }
        });

        // Display Device IP
        android.widget.TextView ipInfo = (android.widget.TextView) findViewById(R.id.ipAddressInfo);
        String ip = getDeviceIpAddress();
        if (ip != null) {
            ipInfo.setText(ip);
        } else {
            ipInfo.setText("No Network");
        }
    }

    public void onScanClick(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) 
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("BeamNG", "No Camera Permission");

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    CAM_PERMISSION_REQUEST);
            return;
        }
        Intent intent = new Intent(this, QRCodeScanner.class);
        startActivity(intent);
    }
    
    // Helper to find the device's IP address
    private String getDeviceIpAddress() {
        try {
            for (java.util.Enumeration<java.net.NetworkInterface> en = java.net.NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                java.net.NetworkInterface intf = en.nextElement();
                for (java.util.Enumeration<java.net.InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    java.net.InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof java.net.Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

