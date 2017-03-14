package com.applepride.pidor.modules.module1.interactor;

import com.applepride.pidor.base.IInteractor;
import com.applepride.pidor.base.InteractorListener;
import com.applepride.pidor.modules.module1.object.TodoListItem;

import java.util.List;

/**
 * Created by Андрей on 14.03.2017.
 */

public interface ILoadTodoItemsInteractor extends IInteractor<Object, List<TodoListItem>> {
    @Override
    void perform(Object param, InteractorListener<List<TodoListItem>> callback);
}
