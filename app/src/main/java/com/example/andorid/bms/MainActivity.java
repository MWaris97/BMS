package com.example.andorid.bms;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

        if(!check()) {
            settingsDiag();
        }

    }

    public void OnLogin(View view) {
        if(!check()){
            settingsDiag();
        }
        else {
            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);
        }
    }

    // for checking the internet connection
    public boolean check(){
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }



    public void settingsDiag(){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("No Internet");
        builder1.setMessage("Please check your Internet connection");
        builder1.setCancelable(false);
        builder1.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                    }
                });

        builder1.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}