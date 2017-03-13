package com.applepride.pidor.modules.module1.decorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.applepride.pidor.App;
import com.applepride.pidor.R;
import com.applepride.pidor.modules.module1.presenter.IModule1Presenter;
import com.applepride.pidor.modules.module1.presenter.Module1Presenter;
import com.applepride.pidor.modules.module1.router.IModule1Router;
import com.applepride.pidor.router.RouterProvider;

public class Module1Activity extends AppCompatActivity implements Module1Decorator {
    IModule1Router router;
    IModule1Presenter presenter;
    Button buttonDialog;
    Button buttonModule2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate all the arch stuff, can be injected
        App app = (App) getApplication();
        final RouterProvider provider = app.getRouterProvider();
        try {
            router = provider.connect(Module1Activity.class, this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        presenter = new Module1Presenter(router);
        presenter.bind(this);


        // initialize view
        buttonDialog = (Button) findViewById(R.id.button_dialog);
        buttonModule2 = (Button) findViewById(R.id.button_module2);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onShowExampleDialog();
            }
        });

        buttonModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNavigateAway();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.unbind();
        }
        super.onDestroy();
    }
}
