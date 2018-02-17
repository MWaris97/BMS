package com.example.andorid.bms;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.concurrent.ExecutionException;

public class chay extends AppCompatActivity {

    GridView lv;
    ArrayAdapter<String> adapter;
    static String[] data1;
    //String[] abc = {"waris","Sorab","Idrees","Arslan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chay);

        lv = (GridView) findViewById(R.id.list_view);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        chay_background background = new chay_background(this);

        try {
            data1 = background.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1);
        lv.setAdapter(adapter);



    }

}
