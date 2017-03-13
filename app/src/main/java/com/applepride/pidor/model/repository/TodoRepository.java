package com.applepride.pidor.model.repository;

import com.applepride.pidor.model.object.TodoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Just an example stuff, lives in memory only
 * PLEASE DO NOT USE THIS IN ANY ACTUAL PROJECT
 */
public final class TodoRepository implements IExampleRepository {

    List<RepositoryChangedListener> listeners = new ArrayList<>();
    List<TodoItem> items;
    int counter = 0;

    private TodoRepository() {
        items = new ArrayList<>();
    }

    public static IExampleRepository create() {
        return new TodoRepository();
    }

    @Override
    public List<TodoItem> getItems() {
        return items;
    }

    @Override
    public void addListener(RepositoryChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(RepositoryChangedListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    @Override
    public void addItem(String value) {
        counter++;
        TodoItem todoItem = new TodoItem(counter, value);
    }

    @Override
    public TodoItem getItem(int id) {
        try {
            return items.get(id);
        } catch (Exception e) {
            return null;
        }
    }
}
