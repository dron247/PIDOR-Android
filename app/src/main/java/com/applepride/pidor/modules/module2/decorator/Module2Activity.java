package com.applepride.pidor.modules.module2.decorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.applepride.pidor.App;
import com.applepride.pidor.R;
import com.applepride.pidor.modules.module2.router.IModule2Router;
import com.applepride.pidor.router.RouterProvider;

public class Module2Activity extends AppCompatActivity {
    IModule2Router router;
    Button buttonDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        App app = (App) getApplication();
        RouterProvider provider = app.getRouterProvider();
        try {
            router = provider.connect(Module2Activity.class, this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        buttonDialog = (Button) findViewById(R.id.button_dialog);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (router != null) {
                    router.openDialog("All good", "Hello world screen 2");
                } else {
                    Toast.makeText(Module2Activity.this, "Router is null", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
