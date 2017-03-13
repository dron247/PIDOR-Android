package com.applepride.pidor.modules.module1.interactor;

import com.applepride.pidor.base.IInteractor;
import com.applepride.pidor.base.InteractorListener;
import com.applepride.pidor.model.object.TodoItem;
import com.applepride.pidor.model.repository.IExampleRepository;
import com.applepride.pidor.modules.module1.object.TodoListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dron on 13.03.17.
 */

public final class LoadTodoItemsInteractor implements IInteractor<Object, List<TodoListItem>> {
    IExampleRepository<TodoItem> repository;

    public LoadTodoItemsInteractor(IExampleRepository<TodoItem> repository) {
        this.repository = repository;
    }

    @Override
    public void perform(Object param, InteractorListener<List<TodoListItem>> callback) {
        if (callback != null) {
            List<TodoListItem> returnList = new ArrayList<>();
            for (TodoItem item : repository.getItems()) {
                returnList.add(new TodoListItem(item.getId(), item.getText()));
            }
            callback.callback(returnList, null);
        }
    }
}
