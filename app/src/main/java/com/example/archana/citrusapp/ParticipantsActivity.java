package com.example.archana.citrusapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ParticipantsActivity extends AppCompatActivity {
    //TextView title;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            TextView mText = (TextView) findViewById(R.id.Titlename);
            mText.setTextSize(30);
            mText.setText(CreateEventActivity.events.get(EventActivity.listNum).title);

            TextView mText2 = (TextView) findViewById(R.id.dateimported);
            mText2.setTextSize(30);
            mText2.setText(CreateEventActivity.events.get(EventActivity.listNum).date);

            TextView mText3 = (TextView) findViewById(R.id.timeimported);
            mText3.setTextSize(30);
            mText3.setText(CreateEventActivity.events.get(EventActivity.listNum).time);

            TextView mText4 = (TextView) findViewById(R.id.locationimported);
            mText4.setTextSize(30);
            mText4.setText(CreateEventActivity.events.get(EventActivity.listNum).location);

            TextView mText5 = (TextView) findViewById(R.id.descriptionimported);
            mText5.setTextSize(30);
            mText5.setText(CreateEventActivity.events.get(EventActivity.listNum).description);

        int numMess = LoginActivity.person.messages.size();
        String name = LoginActivity.person.username;

        if(numMess>=2) {
            TextView m1 = (TextView) findViewById(R.id.message1);
            m1.setText(name + ": " + LoginActivity.person.messages.get(numMess - 1));
        }

        if(numMess>=3) {
            TextView m2 = (TextView) findViewById(R.id.message2);
            m2.setText(name + ": " + LoginActivity.person.messages.get(numMess - 2));
        }

        if(numMess>=4) {
            TextView m3 = (TextView) findViewById(R.id.message3);
            m3.setText(name + ": " + LoginActivity.person.messages.get(numMess - 3));
        }




        Button btnNew = (Button) findViewById(R.id.enterMessage);
        View.OnClickListener oclBtnNew = new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent intent6 = new Intent();
                EditText editText = (EditText) findViewById(R.id.descriptionText);
                String message = editText.getText().toString();
                intent6.putExtra("myExtra6", message);

                /*Intent myIntent7 = getIntent();
                TextView mTextD = (TextView) findViewById(R.id.descriptionText);
                mTextD.setTextSize(30);
                mTextD.setText(myIntent7.getStringExtra("myExtra7"));*/

                //TextView m1 = (TextView) findViewById(R.id.message1);
                //m1.setText(mTextD.getText().toString());

                //m1.setText(printText);

                LoginActivity.person.messages.add(message);

                int numMess = LoginActivity.person.messages.size();
                String name = LoginActivity.person.username;

                if(numMess>=2) {
                    TextView m1 = (TextView) findViewById(R.id.message1);
                    m1.setText(name + ": " + LoginActivity.person.messages.get(numMess - 1));
                }

                if(numMess>=3) {
                    TextView m2 = (TextView) findViewById(R.id.message2);
                    m2.setText(name + ": " + LoginActivity.person.messages.get(numMess - 2));
                }

                if(numMess>=4) {
                    TextView m3 = (TextView) findViewById(R.id.message3);
                    m3.setText(name + ": " + LoginActivity.person.messages.get(numMess - 3));
                }

                editText.setText("");


            }

        };

        Button btnOk = (Button) findViewById(R.id.returnbutton);
        View.OnClickListener oclBtnOk = new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent intent = new Intent(ParticipantsActivity.this, EventActivity.class);
                startActivity(intent);
            }
        };

        btnNew.setOnClickListener(oclBtnNew);
        btnOk.setOnClickListener(oclBtnOk);
    }

}
