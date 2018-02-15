package com.example.andorid.bms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameET , passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = (EditText) findViewById(R.id.ETuser);
        passwordET = (EditText) findViewById(R.id.ETpass);
    }

    public void OnLogin(View view){
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);

    }

}
