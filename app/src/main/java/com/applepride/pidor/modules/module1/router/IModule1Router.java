package com.applepride.pidor.modules.module1.router;

import com.applepride.pidor.base.IRouter;

/**
 * Created by dron on 12.03.17.
 */

public interface IModule1Router extends IRouter {
    void openDialog(String title, String message);

    void openScreen2();
}
