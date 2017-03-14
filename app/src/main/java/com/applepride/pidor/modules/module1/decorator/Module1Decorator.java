package com.applepride.pidor.modules.module1.decorator;

import com.applepride.pidor.base.IDecorator;
import com.applepride.pidor.modules.module1.object.TodoListItem;

import java.util.List;

/**
 * Created by dron on 12.03.17.
 */

public interface Module1Decorator extends IDecorator {
    void setItems(List<TodoListItem> items);
}
