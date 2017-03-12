package com.applepride.pidor.router;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by dron on 12.03.17.
 */

public abstract class BaseRouter {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    protected void showBasicDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.create().show();
    }
}
