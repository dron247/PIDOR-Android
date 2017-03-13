package com.applepride.pidor.model.object;

/**
 * Model level item
 */
public class TodoItem {
    int id;
    String text;

    public TodoItem() {
    }

    public TodoItem(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
