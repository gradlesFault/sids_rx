package com.gradlesfault.sidsrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class ChemistMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
        toolbar = (Toolbar)findViewById(R.id.chemist_main_activty_toolbar);
        setSupportActionBar(toolbar);
    }
}