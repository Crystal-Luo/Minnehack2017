package com.cl.medlog;

/**
 * Created by qwert on 1/29/2017.
 */

public class HistoryItem {
    String message;
    String date;
    public HistoryItem(String message, String date) {
        this.message = message;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
