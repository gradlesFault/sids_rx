package com.gradlesfault.sidsrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import java.util.Random;
import java.lang.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button generate_rx_id_button;
    TextView random_rx;
    EditText patient_id_edittext_doctor;
    Random myRandom;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
        toolbar = (Toolbar) findViewById(R.id.doctor_main_activty_toolbar);
        setSupportActionBar(toolbar);

        createDatabase();

        generate_rx_id_button = (Button) findViewById(R.id.generate_rx_id_button);
        patient_id_edittext_doctor = (EditText) findViewById(R.id.patient_id_edittext_doctor);
        random_rx = (TextView) findViewById(R.id.random_rx);


        generate_rx_id_button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String result = "";
                Random myRandom = new Random();

                result += String.valueOf(myRandom.nextInt());
                String result2 = result.replaceAll("[-+.^:,]", "");

                random_rx.setText(result2);

            }
        });
        insertIntoDB();
    }
    protected void createDatabase(){
        db=openOrCreateDatabase("Random_KEY_db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Rx_Table(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, RX_key VARCHAR);");
    }

    protected void insertIntoDB(){

        String query = "INSERT INTO Rx_Table (name) VALUES('result2');";
        db.execSQL(query);
        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }

}
