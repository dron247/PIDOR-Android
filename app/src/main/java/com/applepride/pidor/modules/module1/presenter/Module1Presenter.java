package com.applepride.pidor.modules.module1.presenter;

import com.applepride.pidor.base.IDecorator;
import com.applepride.pidor.base.InteractorListener;
import com.applepride.pidor.modules.module1.decorator.IModule1Decorator;
import com.applepride.pidor.modules.module1.interactor.ILoadTodoItemsInteractor;
import com.applepride.pidor.modules.module1.object.TodoListItem;
import com.applepride.pidor.modules.module1.router.IModule1Router;

import java.util.List;

/**
 * Created by Андрей on 13.03.2017.
 */

public final class Module1Presenter implements IModule1Presenter {
    private IModule1Decorator decorator = null;
    private IModule1Router router;
    private ILoadTodoItemsInteractor interactor;

    public Module1Presenter(IModule1Router router, ILoadTodoItemsInteractor interactor) {
        this.router = router;
        this.interactor = interactor;
    }

    @Override
    public <E extends IDecorator> void bind(E decorator) {
        this.decorator = (IModule1Decorator) decorator;
    }

    @Override
    public void unbind() {
        this.decorator = null;
    }

    @Override
    public boolean isAttached() {
        return this.decorator != null;
    }


    @Override
    public void loadItems() {
        interactor.perform(null, new InteractorListener<List<TodoListItem>>() {
            @Override
            public void callback(List<TodoListItem> data, Throwable error) {
                if (error == null) {
                    if (isAttached()) {
                        decorator.setItems(data);
                    }
                }
            }
        });
    }


    @Override
    public void onNavigateAway() {
        router.openScreen2();
    }

    @Override
    public void onShowExampleDialog() {
        router.openDialog("All good", "Hello world");
    }
}
