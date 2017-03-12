package com.applepride.pidor.modules.module2.router;

import android.content.Context;

import com.applepride.pidor.router.BaseRouter;

/**
 * Created by dron on 12.03.17.
 */

public final class Module2Router extends BaseRouter implements IModule2Router {
    public Module2Router() {
    }

    @Override
    public void openDialog(String title, String message) {
        super.showBasicDialog(title, message);
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
    }
}
