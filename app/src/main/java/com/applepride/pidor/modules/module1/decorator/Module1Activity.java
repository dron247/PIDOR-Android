package com.applepride.pidor.modules.module1.decorator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.applepride.pidor.App;
import com.applepride.pidor.R;
import com.applepride.pidor.model.object.TodoItem;
import com.applepride.pidor.model.repository.IExampleRepository;
import com.applepride.pidor.model.repository.TodoRepository;
import com.applepride.pidor.modules.module1.interactor.ILoadTodoItemsInteractor;
import com.applepride.pidor.modules.module1.interactor.LoadTodoItemsInteractor;
import com.applepride.pidor.modules.module1.object.TodoListItem;
import com.applepride.pidor.modules.module1.presenter.IModule1Presenter;
import com.applepride.pidor.modules.module1.presenter.Module1Presenter;
import com.applepride.pidor.modules.module1.router.IModule1Router;
import com.applepride.pidor.router.RouterProvider;

import java.util.List;

public class Module1Activity extends AppCompatActivity implements Module1Decorator {
    IModule1Router router;
    IModule1Presenter presenter;
    Button buttonDialog;
    Button buttonModule2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Build dependency objects
        // instantiate all the arch stuff, can be injected
        App app = (App) getApplication();
        final RouterProvider provider = app.getRouterProvider();
        try {
            router = provider.connect(Module1Activity.class, this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        IExampleRepository<TodoItem> repository = new TodoRepository();
        ILoadTodoItemsInteractor loadTodoItemsInteractor = new LoadTodoItemsInteractor(repository);
        presenter = new Module1Presenter(router, loadTodoItemsInteractor);
        presenter.bind(this);
        // end dependency building


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

        presenter.loadItems();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void setItems(List<TodoListItem> items) {
        // populate list
        for (TodoListItem item : items) {
            Log.d("TEST", item.getText());
        }
    }
}
