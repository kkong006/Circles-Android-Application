package com.example.archana.citrusapp;

import java.util.ArrayList;

public class Event {
    String title;
    String date;
    String time;
    String location;
    String description;
    ArrayList<Participant> participants;

    public Event() {
        title = "";
        date = "";
        time = "";
        location = "";
        description = "";
        participants = new ArrayList<>();
    }

    public Event(String t, String d, String ti, String l, String des) {
        title = t;
        date = d;
        time = ti;
        location = l;
        description = des;
        participants = new ArrayList<>(1);
    }

    public String toString() {
        return (title + '\n' + date);
    }

}