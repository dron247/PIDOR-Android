package com.applepride.pidor.modules.module1.router;

import android.content.Context;
import android.content.Intent;

import com.applepride.pidor.modules.module2.decorator.Module2Activity;
import com.applepride.pidor.router.BaseRouter;

/**
 * Created by dron on 12.03.17.
 */

public final class Module1Router extends BaseRouter implements IModule1Router {
    public Module1Router() {
    }

    @Override
    public void openDialog(String title, String message) {
        super.showBasicDialog(title, message);
    }

    @Override
    public void openScreen2() {
        Intent intent = new Intent(context, Module2Activity.class);
        context.startActivity(intent);
    }

    @Override
    public void setContext(Context context) {
        super.setContext(context);
    }
}
