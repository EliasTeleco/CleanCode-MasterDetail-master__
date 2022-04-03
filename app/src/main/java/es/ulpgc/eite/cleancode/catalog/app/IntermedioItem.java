package es.ulpgc.eite.cleancode.catalog.app;

import androidx.annotation.NonNull;

public class IntermedioItem {
    public final int id;
    public final String content;
    public final String details;

    public IntermedioItem(int id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @NonNull
    @Override
    public String toString() {
        return content;
    }
}