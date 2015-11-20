package com.example.archana.citrusapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {


    public ListView listView;
    public static int listNum;

    ImageButton btnOk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String eventList[]  = new String[CreateEventActivity.events.size()];//{"Hi", "Hello", "How are you?", "Testing", "etc"};
        for(int i = 0; i<CreateEventActivity.events.size(); i++) {
            eventList[i] = CreateEventActivity.events.get(i).title + '\n' + CreateEventActivity.events.get(i).date;
        }
        listView = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, eventList);//CHANGE TO EVENTS, (CONTEXT, LAYOUT,TEXT VIEW ID,ARRAY)
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(EventActivity.this, ParticipantsActivity.class);
                startActivity(i);
                listNum = position;
            }
        });

        btnOk = (ImageButton) findViewById(R.id.addeventbutton);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, CreateEventActivity.class);
                startActivity(intent);
            }
        };
        btnOk.setOnClickListener(oclBtnOk);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public static int getNum() {
        return listNum;
    }

}