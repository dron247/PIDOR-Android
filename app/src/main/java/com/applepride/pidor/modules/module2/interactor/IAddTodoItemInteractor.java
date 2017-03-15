package com.applepride.pidor.modules.module2.interactor;

import com.applepride.pidor.base.IInteractor;
import com.applepride.pidor.base.InteractorListener;


/**
 * Created by Андрей on 15.03.2017.
 */

public interface IAddTodoItemInteractor extends IInteractor<String, Object> {
    @Override
    void perform(String param, InteractorListener<Object> callback);
}
