package com.example.archana.citrusapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateEventActivity extends AppCompatActivity {

    public Event e;
    public static ArrayList<Event> events = new ArrayList<>();
    Button btnOk;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnOk = (Button) findViewById(R.id.buttonevent);


        View.OnClickListener oclBtnOk = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText editText = (EditText) findViewById(R.id.TitleText);
                EditText editText2 = (EditText) findViewById(R.id.DateText);
                EditText editText3 = (EditText) findViewById(R.id.TimeText);
                EditText editText4 = (EditText) findViewById(R.id.LocationText);
                EditText editText5 = (EditText) findViewById(R.id.descriptionText);

                Intent intent = new Intent(CreateEventActivity.this, EventSummary.class);
                //date = editText.getText().toString();

                String message = editText.getText().toString();
                String message2 = editText2.getText().toString();
                String message3 = editText3.getText().toString();
                String message4 = editText4.getText().toString();
                String message5 = editText5.getText().toString();

                intent.putExtra("myExtra1", message);
                intent.putExtra("myExtra2", message2);
                intent.putExtra("myExtra3", message3);
                intent.putExtra("myExtra4", message4);
                intent.putExtra("myExtra5", message5);

                e = new Event(message, message2, message3, message4, message5);
                e.participants.add(LoginActivity.person);

                events.add(e);

                startActivity(intent);

            }
        };
        btnOk.setOnClickListener(oclBtnOk);

    }



}
