package com.applepride.pidor.modules.module2.interactor;

import com.applepride.pidor.base.InteractorListener;
import com.applepride.pidor.model.object.TodoItem;
import com.applepride.pidor.model.repository.IExampleRepository;

/**
 * Created by Андрей on 15.03.2017.
 */

public final class AddTodoItemInteractor implements IAddTodoItemInteractor {
    IExampleRepository<TodoItem> repository;

    public AddTodoItemInteractor(IExampleRepository<TodoItem> repository) {
        this.repository = repository;
    }

    @Override
    public void perform(String param, InteractorListener<Object> callback) {
        repository.addItem(param);
        if (callback != null) {
            callback.callback(null, null);
        }
    }
}
