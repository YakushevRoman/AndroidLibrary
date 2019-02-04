package com.example.user301.androidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ListView listView = (ListView) findViewById(R.id.info_list_view);

        String [] list_info = getResources().getStringArray(R.array.my_infarmation);

        ArrayAdapter <String> stringArrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list_info);

        //listView.setAdapter(stringArrayAdapter);

    }
}