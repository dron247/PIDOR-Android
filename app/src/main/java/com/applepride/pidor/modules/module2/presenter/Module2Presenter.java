package com.applepride.pidor.modules.module2.presenter;

import com.applepride.pidor.base.IDecorator;
import com.applepride.pidor.base.InteractorListener;
import com.applepride.pidor.modules.module2.decorator.IModule2Decorator;
import com.applepride.pidor.modules.module2.interactor.IAddTodoItemInteractor;
import com.applepride.pidor.modules.module2.router.IModule2Router;

/**
 * Created by Андрей on 15.03.2017.
 */

public class Module2Presenter implements IModule2Presenter {
    private IModule2Decorator decorator;
    private IModule2Router router;
    private IAddTodoItemInteractor interactor;

    public Module2Presenter(IAddTodoItemInteractor interactor, IModule2Router router) {
        this.router = router;
        this.interactor = interactor;
    }

    @Override
    public <E extends IDecorator> void bind(E decorator) {
        this.decorator = (IModule2Decorator) decorator;
    }

    @Override
    public void unbind() {
        decorator = null;
    }

    @Override
    public boolean isAttached() {
        return decorator != null;
    }

    @Override
    public void onAddClick(String text) {
        if (text.length() > 0) {
            interactor.perform(text, new InteractorListener<Object>() {
                @Override
                public void callback(Object data, Throwable error) {
                    close();
                }
            });
        }
    }

    @Override
    public void onCancelClick() {
        close();
    }

    private void close() {
        if (isAttached()) {
            router.close(decorator.getActivity());
        }
    }
}
