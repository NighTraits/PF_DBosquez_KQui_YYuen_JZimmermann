package com.example.pf_dbosquez_kqui_jzimmermann;

import android.app.PendingIntent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SaveTagNfcActivity extends AppCompatActivity {
    //Intialize attributes
    NfcAdapter nfcAdapter;
    PendingIntent pendingIntent;
    final static String TAG = "nfc_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_nfc);
    }

    public void SaveTag(View v){

    }
}