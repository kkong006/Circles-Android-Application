package com.example.archana.citrusapp;

import java.util.ArrayList;

public class Participant {
    public static String username;
    public static ArrayList<String> messages = new ArrayList<>(1);

    public Participant() {
        username = "";
    }

    public Participant(String u, String m)
    {
        username = u;
        messages.add(m);
    }
}