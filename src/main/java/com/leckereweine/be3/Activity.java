package com.leckereweine.be3;

import java.time.LocalDateTime;

public class Activity {
    private String date;
    private String description;
    private boolean status;
    private final static String identifier = "Compras";
    private String user;

    public Activity() {
    }

    public Activity(String date, String description, boolean status, String user) {
        this.date = date;
        this.description = description;
        this.status = status;
        this.user = user;
    }
}
