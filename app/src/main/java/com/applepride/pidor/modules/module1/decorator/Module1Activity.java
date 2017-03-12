package com.applepride.pidor.modules.module1.decorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.applepride.pidor.App;
import com.applepride.pidor.R;
import com.applepride.pidor.modules.module1.router.IModule1Router;
import com.applepride.pidor.router.RouterProvider;

public class Module1Activity extends AppCompatActivity {
    IModule1Router router;
    Button buttonDialog;
    Button buttonModule2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App app = (App) getApplication();
        RouterProvider provider = app.getRouterProvider();
        try {
            router = provider.connect(Module1Activity.class, this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        buttonDialog = (Button) findViewById(R.id.button_dialog);
        buttonModule2 = (Button) findViewById(R.id.button_module2);

        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (router != null) {
                    router.openDialog("All good", "Hello world");
                } else {
                    Toast.makeText(Module1Activity.this, "Router is null", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (router != null) {
                    router.openModule2();
                } else {
                    Toast.makeText(Module1Activity.this, "Router is null", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
