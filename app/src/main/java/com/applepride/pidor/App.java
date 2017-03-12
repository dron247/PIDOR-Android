package com.applepride.pidor;

import android.app.Application;

import com.applepride.pidor.modules.module1.decorator.Module1Activity;
import com.applepride.pidor.modules.module1.router.Module1Router;
import com.applepride.pidor.modules.module2.decorator.Module2Activity;
import com.applepride.pidor.modules.module2.router.Module2Router;
import com.applepride.pidor.router.RouterProvider;

/**
 * Created by Андрей on 07.03.2017.
 */

public final class App extends Application {

    private RouterProvider provider;

    public RouterProvider getRouterProvider() {
        return provider;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        provider = RouterProvider.create();
        registerModules(provider);
    }

    void registerModules(RouterProvider rp) {
        rp.register(Module1Activity.class, Module1Router.class);
        rp.register(Module2Activity.class, Module2Router.class);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
