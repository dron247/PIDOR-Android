package com.applepride.pidor.modules.module1.presenter;

import com.applepride.pidor.base.IDecorator;
import com.applepride.pidor.modules.module1.decorator.Module1Decorator;
import com.applepride.pidor.modules.module1.router.IModule1Router;

/**
 * Created by Андрей on 13.03.2017.
 */

public final class Module1Presenter implements IModule1Presenter {
    Module1Decorator decorator = null;
    IModule1Router router;

    public Module1Presenter(IModule1Router router) {
        this.router = router;
    }

    @Override
    public <E extends IDecorator> void bind(E decorator) {
        this.decorator = (Module1Decorator) decorator;
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
    public void onNavigateAway() {
        router.openScreen2();
    }

    @Override
    public void onShowExampleDialog() {
        router.openDialog("All good", "Hello world");
    }
}
